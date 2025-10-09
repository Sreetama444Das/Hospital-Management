package com.sprint.hospital_management.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "procedures")
public class Procedure {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer code;
	
	private String name;
	private Double cost;
	
	public Procedure() {}
	
	public Procedure(String name,Double cost) {
		this.setName(name);
		this.cost = cost;
	}

	public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
