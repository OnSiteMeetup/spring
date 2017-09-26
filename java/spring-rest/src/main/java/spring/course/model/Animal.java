package spring.course.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "ANI_MASTER")
public class Animal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Ani_Name")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String aniName;

	@NotEmpty
	@Column(name = "Avg_Age", nullable = false)
	private Long avgAge;

	@NotEmpty
	@Column(name = "Height", nullable = false)
	private Long height;

	@Column(name = "Weight")
	private Long weight;

	@Column(name = "Food_Style")
	private String foodStyle;

	@Column(name = "Extincting_Species")
	private String extinctingSpecies;

	public Animal() {
	}

	public Animal(String aniName, Long avgAge , Long height, Long weight ,String foodStyle , String extinctinSpecies) {
		this.aniName = aniName;
		this.avgAge = avgAge;
		this.height = height;
		this.weight = weight;
		this.foodStyle = foodStyle;
		this.extinctingSpecies = extinctingSpecies;
	}

	public String getAniName() {
		return aniName;
	}

	public void setAniName(String aniName) {
		this.aniName = aniName;
	}

	public Long getAvgAge() {
		return avgAge;
	}

	public void setAvgAge(Long avgAge) {
		this.avgAge = avgAge;
	}

	public Long getHeight() {
		return height;
	}

	public void setHeight(Long lastName) {
		this.height = height;
	}

	public Long getWeight() {
		return weight;
	}

	public void setWeight(Long weight) {
		this.weight = weight;
	}

	public String getFoodStyle() {
		return foodStyle;
	}

	public void setFoodStyle(String foodStyle) {
		this.foodStyle = foodStyle;
	}

	public String getExtinctingSpecies() {
		return extinctingSpecies;
	}

	public void setExtinctingSpecies(String extinctingSpecies) {
		this.extinctingSpecies = extinctingSpecies;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((foodStyle == null) ? 0 : foodStyle.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
		result = prime * result + ((avgAge == null) ? 0 : avgAge.hashCode());
		result = prime * result + ((aniName == null) ? 0 : aniName.hashCode());
		result = prime * result + ((height == null) ? 0 : height.hashCode());
		result = prime * result + ((extinctingSpecies == null) ? 0 : extinctingSpecies.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (foodStyle == null) {
			if (other.foodStyle != null)
				return false;
		} else if (!foodStyle.equals(other.foodStyle))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		if (avgAge == null) {
			if (other.avgAge != null)
				return false;
		} else if (!avgAge.equals(other.avgAge))
			return false;
		if (aniName == null) {
			if (other.aniName != null)
				return false;
		} else if (!aniName.equals(other.aniName))
			return false;
		if (height == null) {
			if (other.height != null)
				return false;
		} else if (!height.equals(other.height))
			return false;
		if (extinctingSpecies == null) {
			if (other.extinctingSpecies != null)
				return false;
		} else if (!extinctingSpecies.equals(other.extinctingSpecies))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Animal [aniName=" + aniName + ", avgAge=" + avgAge + ", height=" + height + ", weight=" + weight
				+ ", foodStyle=" + foodStyle + ", extinctingSpecies=" + extinctingSpecies + "]";
	}

}
