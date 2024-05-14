public class Test {
    public static void main(String[] args) {
        testUserGUI();

        /*testWelcomeGUI();
        testRegisterGUI();
        testAdminGUI();
        testUserGUI();
        testAddGarbageGUI();
        testShowGarbage();
        testDeleteGUI();*/
    }

    private static void testWelcomeGUI() {
        AllGUI gui = new AllGUI();
        gui.showGUI();
    }


    private static void testRegisterGUI() {
        AllGUI gui = new AllGUI();
        gui.RegisterGUI();
    }

    private static void testAdminGUI() {
        AllGUI gui = new AllGUI();
        gui.AdminGUI();
    }

    private static void testUserGUI() {
        AllGUI gui = new AllGUI();
        gui.UserGUI();
    }

    private static void testAddGarbageGUI() {
        AllGUI gui = new AllGUI();
        gui.AddGarbageGUI();
    }

    private static void testShowGarbage() {
        AllGUI gui = new AllGUI();
        gui.showGarbage();
    }

    private static void testDeleteGUI() {
        AllGUI gui = new AllGUI();
        gui.DeleteGUI();
    }
}
