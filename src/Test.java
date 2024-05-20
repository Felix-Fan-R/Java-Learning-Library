public class Test {
    public static void main(String[] args) {
        //testUserGUI();
        testWelcomeGUI();
        /*testWelcomeGUI();
        testRegisterGUI();
        testAdminGUI();
        testUserGUI();
        testAddGarbageGUI();
        testShowGarbage();
        testDeleteGUI();*/
    }

    private static void testWelcomeGUI() {
        AllGUI.showGUI();
    }


    private static void testRegisterGUI() {
        AllGUI.RegisterGUI();
    }

    private static void testAdminGUI() {
        AllGUI.AdminGUI();
    }

    private static void testUserGUI() {
        AllGUI.UserGUI();
    }

    private static void testAddGarbageGUI() {
        AllGUI.AddGarbageGUI();
    }

    private static void testShowGarbage() {
        AllGUI.showGarbage();
    }

    private static void testDeleteGUI() {
        AllGUI.DeleteGUI();
    }
}
