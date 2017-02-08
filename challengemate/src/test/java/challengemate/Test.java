package challengemate;

import org.json.JSONObject;

import com.challengemate.model.User;

public class Test {

	public static void main(String[] args) {
		User user = new User();
		user.setId(1l);
		user.setName("yoyo");
		JSONObject jsonObject = new JSONObject(user);
		System.out.println(jsonObject);

	}
}