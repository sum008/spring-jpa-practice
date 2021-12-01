package com.jpa.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
@Embeddable
@AttributeOverride(name = "name",
column = @Column(name="guardian_name"))

@AttributeOverride(name = "email",
column = @Column(name="guardian_email"))

@AttributeOverride(name = "mobileNo",
column = @Column(name="guardian_mobile"))
public class GuardianEntity {
	
	private String name;
	private String email;
	private String mobileNo;

}
