package solid.ren.themeskinning;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        String skinUrl = "https://raw.githubusercontent.com/burgessjp/ThemeSkinning/master/app/src/main/assets/skin/theme.skin";

        String name = skinUrl.substring(skinUrl.lastIndexOf("/")+1);
        assertEquals("theme.skin", name);
    }
}