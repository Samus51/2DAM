package ad.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ad.ConexionBBDD.Conexion;
import ad.models.City;
import ad.models.Country;

public class CRUD {

	public Country createCountry(Country country) {
		String sql = "INSERT INTO Country (code, name, continent, region, surfaceArea, indepYear, population, lifeExpectancy, gnp, gnpOld, localName, governmentForm, headOfState, capital, code2) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection conexion = Conexion.conectar(); PreparedStatement pr1 = conexion.prepareStatement(sql)) {
			pr1.setString(1, country.getCode());
			pr1.setString(2, country.getName());
			pr1.setString(3, country.getContinent());
			pr1.setString(4, country.getRegion());
			pr1.setDouble(5, country.getSurfaceArea());
			pr1.setInt(6, country.getIndepYear());
			pr1.setInt(7, country.getPopulation());
			pr1.setDouble(8, country.getLifeExpectancy());
			pr1.setDouble(9, country.getGnp());
			pr1.setDouble(10, country.getGnpOld());
			pr1.setString(11, country.getLocalName());
			pr1.setString(12, country.getGovernmentForm());
			pr1.setString(13, country.getHeadOfState());
			pr1.setInt(14, country.getCapital());
			pr1.setString(15, country.getCode2());
			pr1.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return country;
	}

	public void readCountryByCode(String code) {
		String sql = "SELECT * FROM Country WHERE code = ?";
		Country country = null;
		try (Connection conexion = Conexion.conectar(); PreparedStatement pr1 = conexion.prepareStatement(sql)) {

			pr1.setString(1, code);
			ResultSet rs = pr1.executeQuery();

			if (rs.next()) {
				 country = new Country(rs.getString("code"), rs.getString("name"), rs.getString("continent"),
						rs.getString("region"), rs.getDouble("surfaceArea"), rs.getInt("indepYear"), rs.getInt("population"),
						rs.getDouble("lifeExpectancy"), rs.getDouble("gnp"), rs.getDouble("gnpOld"), rs.getString("localName"),
						rs.getString("governmentForm"), rs.getString("headOfState"), rs.getInt("capital"), rs.getString("code2"));
				country.toString();
			}
			System.out.println(country.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void updateCountry(Country country) {
    String sql = "UPDATE Country SET name = ?, continent = ?, region = ?, surfaceArea = ?, indepYear = ?, population = ?, lifeExpectancy = ?, gnp = ?, gnpOld = ?, localName = ?, governmentForm = ?, headOfState = ?, capital = ?, code2 = ? WHERE code = ?";
    
    try (Connection conexion = Conexion.conectar(); 
         PreparedStatement pr1 = conexion.prepareStatement(sql)) {
        
        pr1.setString(1, country.getName());
        pr1.setString(2, country.getContinent());
        pr1.setString(3, country.getRegion());
        pr1.setDouble(4, country.getSurfaceArea());
        pr1.setInt(5, country.getIndepYear());
        pr1.setInt(6, country.getPopulation());
        pr1.setDouble(7, country.getLifeExpectancy());
        pr1.setDouble(8, country.getGnp());
        pr1.setDouble(9, country.getGnpOld());
        pr1.setString(10, country.getLocalName());
        pr1.setString(11, country.getGovernmentForm());
        pr1.setString(12, country.getHeadOfState());
        pr1.setInt(13, country.getCapital());
        pr1.setString(14, country.getCode2());
        
        pr1.setString(15, country.getCode());
        
        pr1.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


	public void deleteCountry(String code) {
		String sqlLanguageReferencia = "DELETE FROM countrylanguage WHERE CountryCode = ?";
		String sqlCityReferencia = "DELETE FROM City WHERE CountryCode = ?";
		String sqlCountry = "DELETE FROM Country WHERE code = ?";

		try (Connection conexion = Conexion.conectar();
				PreparedStatement prLanguage = conexion.prepareStatement(sqlLanguageReferencia);
				PreparedStatement prCity = conexion.prepareStatement(sqlCityReferencia);
				PreparedStatement prCountry = conexion.prepareStatement(sqlCountry)) {

			prLanguage.setString(1, code);
			prLanguage.executeUpdate();

			prCity.setString(1, code);
			prCity.executeUpdate();

			prCountry.setString(1, code);
			prCountry.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public City createCity(City city) {
		String sql = "INSERT INTO City (name, countryCode, district, population) VALUES (?, ?, ?, ?)";
		try (Connection conexion = Conexion.conectar();
				PreparedStatement pr1 = conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
			pr1.setString(1, city.getName());
			pr1.setString(2, city.getCountryCode());
			pr1.setString(3, city.getDistrict());
			pr1.setInt(4, city.getPopulation());
			int rs = pr1.executeUpdate();

			if (rs > 0) {
				ResultSet keys = pr1.getGeneratedKeys();
				if (keys.next()) {
					city.setId(keys.getInt(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return city;
	}

	public City readCityById(int id) {
		City city = null;
		String sql = "SELECT * FROM cities WHERE id = ?";
		try (Connection conexion = Conexion.conectar(); PreparedStatement pr1 = conexion.prepareStatement(sql)) {
			pr1.setInt(1, id);
			ResultSet rs = pr1.executeQuery();
			if (rs.next()) {
				city = new City(rs.getInt("id"), rs.getString("name"), rs.getString("countryCode"), rs.getString("district"),
						rs.getInt("population"));
				city.toString();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return city;
	}

	public void updateCity(City city) {
		String sql = "UPDATE cities SET name = ?, countryCode = ?, district = ?, population = ? WHERE id = ?";
		try (Connection conexion = Conexion.conectar(); PreparedStatement pr1 = conexion.prepareStatement(sql)) {
			pr1.setString(1, city.getName());
			pr1.setString(2, city.getCountryCode());
			pr1.setString(3, city.getDistrict());
			pr1.setInt(4, city.getPopulation());
			pr1.setInt(5, city.getId());
			pr1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteCity(int id) {
		String sql = "DELETE FROM City WHERE id = ?";
		try (Connection conexion = Conexion.conectar(); PreparedStatement pr1 = conexion.prepareStatement(sql)) {
			pr1.setInt(1, id);
			pr1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		CRUD crud = new CRUD();
		City ciudadPinis = new City(200000, "Pacolandia", "ESP", "Guarroman", 1);
	
		
		crud.createCity(ciudadPinis);
	}

	/**
	 * @Override public List<Country> readAllCountries() { List<Country> countries =
	 *           new ArrayList<>(); String sql = "SELECT * FROM Country"; try
	 *           (Connection conexion = Conexion.conectar(); PreparedStatement pr1 =
	 *           conexion.prepareStatement(sql)) { ResultSet rs =
	 *           pr1.executeQuery(); while (rs.next()) { Country country = new
	 *           Country(rs.getString("code"), rs.getString("name"),
	 *           rs.getString("continent"), rs.getString("region"),
	 *           rs.getDouble("surfaceArea"), rs.getInt("indepYear"),
	 *           rs.getInt("population"), rs.getDouble("lifeExpectancy"),
	 *           rs.getDouble("gnp"), rs.getDouble("gnpOld"),
	 *           rs.getString("localName"), rs.getString("governmentForm"),
	 *           rs.getString("headOfState"), rs.getInt("capital"),
	 *           rs.getString("code2")); countries.add(country); } } catch
	 *           (SQLException e) { e.printStackTrace(); } return countries; }
	 */
	public List<City> readAllCities() {
		List<City> cities = new ArrayList<>();
		String sql = "SELECT * FROM City";
		try (Connection conexion = Conexion.conectar(); PreparedStatement pr1 = conexion.prepareStatement(sql)) {
			ResultSet rs = pr1.executeQuery();
			while (rs.next()) {
				City city = new City(rs.getInt("id"), rs.getString("name"), rs.getString("countryCode"),
						rs.getString("district"), rs.getInt("population"));
				cities.add(city);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cities;
	}

}
