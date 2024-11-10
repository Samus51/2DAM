package rawg.functions;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.json.JSONArray;
import org.json.JSONObject;

import utils.rawg.HibernateUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

public class Sincronizador {

	private static final String API_URL = "https://api.rawg.io/api/games";
	private static final String API_KEY = "tu_api_key";

	public void syncGames() {
		try {
			String urlString = API_URL + "?key=" + API_KEY;
			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");

			int responseCode = connection.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				StringBuilder response = new StringBuilder();
				String inputLine;

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();

				JSONObject jsonResponse = new JSONObject(response.toString());
				JSONArray gamesArray = jsonResponse.getJSONArray("results");

				for (int i = 0; i < gamesArray.length(); i++) {
					JSONObject gameJson = gamesArray.getJSONObject(i);
					int gameId = gameJson.getInt("id");
					String name = gameJson.getString("name");
					String released = gameJson.optString("released", null);

					Game game = getGameById(gameId);
					if (game == null) {
						game = new Game();
						game.setId(gameId);
					}
					game.setName(name);
					game.setReleased(released != null ? java.sql.Date.valueOf(released) : null);

					saveOrUpdateGame(game);
				}
			} else {
				System.out.println("Error en la petición: " + responseCode);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Juegos getGameById(int id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(Game.class, id);
		}
	}

	private void saveOrUpdateGame(Game game) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.saveOrUpdate(game);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
}
