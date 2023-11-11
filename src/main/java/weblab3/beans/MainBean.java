//package weblab3.beans;
//
//
//
//// Аннотации managed bean компонента
//@ManagedBean(name="Main") // определение managed bean и его наименования
//@ApplicationScoped          // определение времени жизни - request
//public class MainBean
//{
//    private String login;
//    private String password;
//
//    public MainBean(){
//        System.out.println("MAIN BEAN");
//    }
//
//    public String getLogin() {
//        return login;
//    }
//
//    public void setLogin(String login) {
//        this.login = login;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    /* Метод простейшей авторизации.
//     * Выполняется проверка имени и пароля пользователя.
//     * Результат проверки - наименование страницы перехода
//     */
//    public String checkLogin(){
//        if (login.equalsIgnoreCase("alex") && password.equalsIgnoreCase("qwerty")){
//            return "loginsuccess?faces-redirect=true";
//        } else {
//            return "loginfailed?faces-redirect=true";
//        }
//    }
//}