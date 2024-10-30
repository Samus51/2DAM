package ad.models;

public class CountryLanguage {

	private int CountryCode;
	private String Language;
	private IsOfficial isOfficial;
	private double percentage;

	public CountryLanguage(int countryCode, String language, IsOfficial isOfficial, double percentage) {
		CountryCode = countryCode;
		Language = language;
		this.isOfficial = isOfficial;
		this.percentage = percentage;
	}

	public enum IsOfficial {
		T, F
	}

	/**
	 * @return the countryCode
	 */
	public int getCountryCode() {
		return CountryCode;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return Language;
	}

	/**
	 * @return the isOfficial
	 */
	public IsOfficial getIsOfficial() {
		return isOfficial;
	}

	/**
	 * @return the percentage
	 */
	public double getPercentage() {
		return percentage;
	}

	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(int countryCode) {
		CountryCode = countryCode;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		Language = language;
	}

	/**
	 * @param isOfficial the isOfficial to set
	 */
	public void setIsOfficial(IsOfficial isOfficial) {
		this.isOfficial = isOfficial;
	}

	/**
	 * @param percentage the percentage to set
	 */
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

}
