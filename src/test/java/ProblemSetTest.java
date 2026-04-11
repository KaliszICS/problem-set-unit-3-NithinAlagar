// import static org.junit.jupiter.api.Assertions.*;
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;

// public class ProblemSetTest {
// @Test
// @DisplayName("")

//         // ---------- OPTION 1: BASIC VALIDATION ----------
//     void testValidEmail() {
//         assertEquals("john.doe@example.com: Valid | Local: john.doe | Domain: example.com", ProblemSet.emailPrinter("john.doe@example.com"));
//     }

//     @Test
//     void testMissingAt() {
//         assertEquals("johndoeexample.com: Invalid: Missing @", ProblemSet.emailPrinter("johndoeexample.com"));
//     }

//     @Test
//     void testMultipleAt() {
//         assertEquals("john@@example.com: Invalid: Multiple @", ProblemSet.emailPrinter("john@@example.com"));
//     }

//     @Test
//     void testStartsWithDot() {
//         assertEquals(".john@example.com: Invalid: Starts or ends with dot", ProblemSet.emailPrinter(".john@example.com"));
//     }

//     @Test
//     void testEndsWithDot() {
//         assertEquals("john@example.com.: Invalid: Starts or ends with dot", ProblemSet.emailPrinter("john@example.com."));
//     }

//     @Test
//     void testContainsSpaces() {
//         assertEquals("john doe@example.com: Invalid: Contains spaces", ProblemSet.emailPrinter("john doe@example.com"));
//     }

//     @Test
//     void testLocalTooLong() {
//         String longLocal = "a".repeat(65) + "@example.com";
//         assertEquals(longLocal + ": " +"Invalid: Local part too long", ProblemSet.emailPrinter(longLocal));
//     }

//     @Test
//     void testLocalTooShort() {
//         assertEquals("@example.com: Invalid: Local part too short", ProblemSet.emailPrinter("@example.com"));
//     }

//     @Test
//     void testNoDotInDomain() {
//         assertEquals("john@examplecom: Invalid: No dot in domain", ProblemSet.emailPrinter("john@examplecom"));
//     }

//     @Test
//     void testInvalidExtensionShort() {
//         assertEquals("john@example.c: Invalid: Invalid domain extension length", ProblemSet.emailPrinter("john@example.c"));
//     }

//     @Test
//     void testInvalidExtensionLong() {
//         assertEquals("john@example.toolong: Invalid: Invalid domain extension length", ProblemSet.emailPrinter("john@example.toolong"));
//     }

//     // ---------- OPTION 2: EXCEPTIONS ----------

//     @Test
//     void testSubdomainValid() {
//         assertEquals("user@mail.example.co.uk: Valid | Local: user | Domain: mail.example.co.uk", ProblemSet.emailPrinter("user@mail.example.co.uk"));
//     }

//     @Test
//     void testPlusInLocal() {
//         assertEquals("user+tag@example.com: Valid | Local: user+tag | Domain: example.com", ProblemSet.emailPrinter("user+tag@example.com"));
//     }

//     @Test
//     void testUnderscoreInLocal() {
//         assertEquals("john_doe@example.com: Valid | Local: john_doe | Domain: example.com", ProblemSet.emailPrinter("john_doe@example.com"));
//     }

//     @Test
//     void testInvalidCharacterInDomain() {
//         assertEquals("john@exa+mple.com: Invalid: Invalid characters in domain", ProblemSet.emailPrinter("john@exa+mple.com"));
//     }

//     @Test
//     void testGmailNormalization() {
//         assertEquals("john.doe@gmail.com: Valid (Gmail normalized) | Local: john.doe | Domain: gmail.com", ProblemSet.emailPrinter("john.doe@gmail.com"));
//     }

//     @Test
//     void testGmailStillInvalid() {
//         assertEquals("john doe@gmail.com : Invalid: Contains spaces", ProblemSet.emailPrinter("john doe@gmail.com "));
//     }

//     // ---------- OPTION 3: MULTIPLE EMAILS ----------

//     @Test
//     void testTwoEmailsMixed() {
//         String input = "john.doe@example.com, invalid@domain.z";
//         String expected =
//                 "john.doe@example.com: Valid | Local: john.doe | Domain: example.com\n" +
//                 "invalid@domain.z: Invalid: Invalid domain extension length";

//         assertEquals(expected,  ProblemSet.emailPrinter(input));
//     }

//     @Test
//     void testTwoEmailsBothValid() {
//         String input = "user+tag@mail.example.co.uk, jane.doe@gmail.com";
//         String expected =
//                 "user+tag@mail.example.co.uk: Valid | Local: user+tag | Domain: mail.example.co.uk\n" +
//                 "jane.doe@gmail.com: Valid (Gmail normalized) | Local: jane.doe | Domain: gmail.com";

//         assertEquals(expected,  ProblemSet.emailPrinter(input));
//     }

//     @Test
//     void testTwoEmailsBothInvalid() {
//         String input = "invalidemail.com, @bad.com";
//         String expected =
//                 "invalidemail.com: Invalid: Missing @\n" +
//                 "@bad.com: Invalid: Local part too short";

//         assertEquals(expected,  ProblemSet.emailPrinter(input));
//     }

//     // ---------- EDGE CASES ----------

//     @Test
//     void testExact64CharLocal() {
//         String email = "a".repeat(64) + "@example.com";
//         assertEquals(email + ": Valid | Local: " + "a".repeat(64) + " | Domain: example.com", ProblemSet.emailPrinter(email));
//     }

//     @Test
//     void testExtensionLength2() {
//         assertEquals("john@example.ca: Valid | Local: john | Domain: example.ca", ProblemSet.emailPrinter("john@example.ca"));
//     }

//     @Test
//     void testExtensionLength6() {
//         assertEquals("john@example.travel: Valid | Local: john | Domain: example.travel", ProblemSet.emailPrinter("john@example.travel"));
//     }

//     @Test
//     void testTrailingSpace() {
//         assertEquals("john@example.com : Invalid: Contains spaces", ProblemSet.emailPrinter("john@example.com "));
//     }

//     // ---------- BUG DETECTION TESTS ----------

//     @Test
//     void testHyphenInDomain() {
//         // This SHOULD be valid in real emails
//         // Your code currently fails this → good test to catch bug
//         assertEquals("john@my-domain.com: Valid | Local: john | Domain: my-domain.com", ProblemSet.emailPrinter("john@my-domain.com"));
//     }

//     @Test
//     void testInvalidSingleEmailPrinter() {
//         String result = ProblemSet.emailPrinter("invalidemail");
//         assertTrue(result.contains("Invalid"));
//     }

// }






