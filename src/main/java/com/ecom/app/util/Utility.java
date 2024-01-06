package com.ecom.app.util;

import java.nio.charset.Charset;
import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import com.ecom.app.enums.UserType;
import com.ecom.app.model.CredentialMaster;
import com.ecom.app.repository.CredentialMasterRepository;

/**
 * This class provides utility function for sending HTTP POST, PATCH, DELETE
 * request to a different endpoint
 */
@Component
@SuppressWarnings("unused")
public class Utility {

	
	@Autowired
	private CredentialMasterRepository credentialMasterRepository;
	
	private static int responseCount(com.squareup.okhttp.Response response) {
		int result = 1;
		while ((response = response.priorResponse()) != null) {
			result++;
		}
		return result;
	}

	public static HttpHeaders createHeaders(String username, String password) {
		return new HttpHeaders() {
			{
				String auth = username + ":" + password;
				byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);
				set("Authorization", authHeader);
			}
		};
	}

	public boolean hasPermission(String url, String methodType, String username) {

		boolean hasPermission = false;
		try {

			Optional<CredentialMaster> credentialMasterOptional = credentialMasterRepository.findByEmail(username);
			if (credentialMasterOptional.isPresent()) {
				String userType = credentialMasterOptional.get().getUserTypeId().name();
				if (userType.equalsIgnoreCase(UserType.Customer.name())) {
					return true;
				} else {
					if (userType.equalsIgnoreCase(UserType.Dealer.name())) {
						return true;
					} else {
						if (userType.equalsIgnoreCase(UserType.Owner.name())) { 
//							List<Long> permissionIdList = userSiteRoleRepository
//									.findPermissionByUser(credentialMasterOptional.get().getUserId());
//							List<Permission> permissionList = permissionRepository.findAllById(permissionIdList);
//							for (Permission permission : permissionList) {
//								if (permission.isActive() && permission.getUrl() != null
//										&& permission.getUrl().equalsIgnoreCase(url)
//										&& permission.getMethodType() != null
//										&& permission.getMethodType().equalsIgnoreCase(methodType)) {
//									hasPermission = true;
//									break;
//								}
//							}
							return true;
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hasPermission;
	}
}