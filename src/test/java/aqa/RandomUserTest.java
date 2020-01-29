package aqa;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.ValidatableResponse;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

@RunWith(Parameterized.class)
public class RandomUserTest {

    private final static String URL = "https://randomuser.me/api/";

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"male", null}, {"female", "name"}, {"female", null}, {"female", "name, location"}
        });
    }

    private final String gender, params;

    public RandomUserTest(String gender, String params) {
        this.gender = gender;
        this.params = params;
    }

    @Test
    public void myFirstTest() {
        ValidatableResponse response;
        if (gender.equals("male")) {
            response = makeAndPrintRequest(getRandomMale());
        } else {
            response = makeAndPrintRequest(getRandomFemale(params));
        }

        response.statusCode(200);
        //hamcrest
//        response.body(containsString("asdasdasdasdasdasdasdasd"));
        response.body(containsString("seed"));
        response.body(not(containsString("asdasdasdasdasdasdasdasd")));

        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(1).isEqualTo(1);
        softAssertions.assertThat(1).isEqualTo(2);
        softAssertions.assertThat(2).isEqualTo(2);
        softAssertions.assertThat(3).isEqualTo(2);
        softAssertions.assertThat(3).isEqualTo(3);

        softAssertions.assertAll();
//        assertThat("This is the comment", 1, is(1));
//        assertThat("This is the comment", 1, is(2));
    }

    public ValidatableResponse makeAndPrintRequest(HashMap params) {
        return RestAssured.given().queryParams(params).get(URL).then();
    }

    public HashMap getRandomFemale(String reqeustParams) {
        HashMap map = new HashMap();
        map.put("inc", reqeustParams);
        map.put("gender", "female");
        return map;
    }

    public HashMap getRandomMale() {
        HashMap map = new HashMap();
        map.put("inc", "gender,name,nat");
        map.put("gender", "male");
        return map;
    }
}

/*


    public static void main(String... args) {
        try {
            makeAndPrintRequest(getRandomMale());
            makeAndPrintRequest(getRandomMale());
            makeAndPrintRequest(getRandomFemale("name"));
            makeAndPrintRequest(getRandomFemale("email"));
            makeAndPrintRequest(getRandomFemale("title"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


 */