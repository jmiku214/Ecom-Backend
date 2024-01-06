package com.ecom.app.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Pagination<T> {

    private int totalPages;
    private int numberOfElements;
    private long totalElements;
    private T data;
    private Long totalGpsEquiptedVehicle;

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getTotalGpsEquiptedVehicle() {
        return totalGpsEquiptedVehicle;
    }

    public void setTotalGpsEquiptedVehicle(Long totalGpsEquiptedVehicle) {
        this.totalGpsEquiptedVehicle = totalGpsEquiptedVehicle;
    }
}
