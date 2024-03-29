package com.ecom.app.constant;

import com.ecom.app.dto.OrderDetailsDto;

public class EmailConstant {

	public final static String generateInvoice(OrderDetailsDto detailsDto) {
		return "<html>\n"
				+ "\n"
				+ "<head>\n"
				+ "	<meta charset=\"utf-8\">\n"
				+ "	<title>Invoice</title>\n"
				+ "	<link rel=\"stylesheet\" href=\"style.css\">\n"
				+ "	<script src=\"script.js\"></script>\n"
				+ "</head>\n"
				+ "<body>\n"
				+ "	<header>\n"
				+ "		<h1>Invoice</h1>\n"
				+ "		<address contenteditable>\n"
				+ "			<p>"+detailsDto.getUser().getUserName()+"</p>\n"
				+ "			<p>"+detailsDto.getAddress().getAddress()+", "+detailsDto.getAddress().getNearByLocationAddress()+"</p>\n"
				+ "			<p>"+detailsDto.getAddress().getCity().getCityName()+"</p>\n"
				+ "			<p>"+detailsDto.getAddress().getState().getStateName()+"</p>\n"
				+ "			<p>"+detailsDto.getAddress().getPincode()+"</p>\n"
				+ "			<p>"+detailsDto.getAddress().getPhone()+"</p>\n"
				+ "		</address>\n"
				+ "	</header>\n"
				+ "	<article>\n"
				+ "		<h1>Recipient</h1>\n"
				+ "		<address contenteditable>\n"
				+ "			<p>E-COM<br>c/o D.Moharana & M.Jena</p>\n"
				+ "		</address>\n"
				+ "		<table class=\"meta\">\n"
				+ "			<tr>\n"
				+ "				<th><span contenteditable>Order #</span></th>\n"
				+ "				<td><span contenteditable>"+detailsDto.getUuid()+"</span></td>\n"
				+ "			</tr>\n"
				+ "			<tr>\n"
				+ "				<th><span contenteditable>Date</span></th>\n"
				+ "				<td><span contenteditable>"+detailsDto.getOrderAt()+"</span></td>\n"
				+ "			</tr>\n"
				+ "			<tr>\n"
				+ "				<th><span contenteditable>Total Amount</span></th>\n"
				+ "				<td><span id=\"prefix\" contenteditable>$</span><span>"+detailsDto.getProduct().getPrice()+"</span></td>\n"
				+ "			</tr>\n"
				+ "		</table>\n"
				+ "		<table class=\"inventory\">\n"
				+ "			<thead>\n"
				+ "				<tr>\n"
				+ "					<th><span contenteditable>Item</span></th>\n"
				+ "					<th><span contenteditable>Description</span></th>\n"
				+ "					<th><span contenteditable>Rate</span></th>\n"
				+ "					<th><span contenteditable>Quantity</span></th>\n"
				+ "					<th><span contenteditable>Price</span></th>\n"
				+ "				</tr>\n"
				+ "			</thead>\n"
				+ "			<tbody>\n"
				+ "				<tr>\n"
				+ "					<td><a class=\"cut\">-</a><span contenteditable>"+detailsDto.getProductName()+"</span></td>\n"
				+ "					<td><span contenteditable>"+detailsDto.getProduct().getProductName()+" - "+detailsDto.getProduct().getModelName()+"</span></td>\n"
				+ "					<td><span data-prefix>$</span><span contenteditable>"+detailsDto.getProduct().getPrice()+"</span></td>\n"
				+ "					<td><span contenteditable>1</span></td>\n"
				+ "					<td><span data-prefix>$</span><span>"+detailsDto.getProduct().getPrice()+"</span></td>\n"
				+ "				</tr>\n"
				+ "			</tbody>\n"
				+ "		</table>\n"
				+ "		<table class=\"balance\">\n"
				+ "			<tr>\n"
				+ "				<th><span contenteditable>Total</span></th>\n"
				+ "				<td><span data-prefix>$</span><span>"+detailsDto.getProduct().getPrice()+"</span></td>\n"
				+ "			</tr>\n"
				+ "			<tr>\n"
				+ "				<th><span contenteditable>Amount Paid</span></th>\n"
				+ "				<td><span data-prefix>$</span><span contenteditable>0.00</span></td>\n"
				+ "			</tr>\n"
				+ "			<tr>\n"
				+ "				<th><span contenteditable>Amount To Pay</span></th>\n"
				+ "				<td><span data-prefix>$</span><span>"+detailsDto.getProduct().getPrice()+"</span></td>\n"
				+ "			</tr>\n"
				+ "		</table>\n"
				+ "	</article>\n"
				+ "</body>\n"
				+ "\n"
				+ "</html>";
	}
	
	
}
