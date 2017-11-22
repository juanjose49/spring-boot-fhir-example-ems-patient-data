package com.fhirio.fhiremsservice.domain;

/**
 * Created by on 11/16/17.
 */
/**
 *
 */
public class Measurement {

    private String measurementUuid;
    private String code;
    private String name;
    private String system;
    private String valueCode;
    private String description;
    private double value;
    private String valueUnit;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValueCode() {
        return valueCode;
    }

    public void setValueCode(String valueCode) {
        this.valueCode = valueCode;
    }

    public String getMeasurementUuid() {
        return measurementUuid;
    }

    public void setMeasurementUuid(String measurementUuid) {
        this.measurementUuid = measurementUuid;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getValueUnit() {
        return valueUnit;
    }

    public void setValueUnit(String valueUnit) {
        this.valueUnit = valueUnit;
    }
}
