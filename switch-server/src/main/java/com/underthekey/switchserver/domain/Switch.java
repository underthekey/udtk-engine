package com.underthekey.switchserver.domain;

import com.underthekey.common.common.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Switch extends BaseEntity {
	private String name;
	private String model;
	private String manufacturer;
	private String switchType;
	private String actuationForce;
	private String bottomOutForce;
	private String preTravel;
	private String totalTravel;
	private String stemStructure;
	private String stemMaterial;
	private String topHousingMaterial;
	private String bottomHousingMaterial;
	private String mount;
	private Boolean smdLedSupport;
	private String lifespan;
	private String soundUrl;
	private String thumbnailUrl;
	private String imageUrl;
	private String initialForce;
	private String tactileForce;
	private String tactilePeakForce;
	private String tactileEvent;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "brand_id", nullable = false)
	private Brand brand;
}
