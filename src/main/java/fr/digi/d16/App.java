package fr.digi.d16;

import fr.digi.d16.bo.Article;
import fr.digi.d16.bo.Utilisateur;
import fr.digi.d16.dal.DAOFactory;
import fr.digi.d16.dal.IDAO;
import fr.digi.d16.dal.IUtilisateurDAO;
import fr.digi.d16.dal.jdbc.UtilisateurJDBCDAO;

import java.util.Scanner;
import java.util.Set;
import java.sql.*;

/**
 * Hello world!
 *
 */
public class App 
{
    // private static final String DB_URL;
    // private static final String DB_LOGIN;
    // private static final String DB_PWD;
    //
    // static {
    //     ResourceBundle resourceBundle = ResourceBundle.getBundle( "db" );
    //     DB_URL = resourceBundle.getString( "jdbc.db.url" );
    //     DB_LOGIN = resourceBundle.getString( "jdbc.db.user" );
    //     DB_PWD = resourceBundle.getString( "jdbc.db.password" );
    // }
    public static void main( String[] args )
    {
        authenticate();
        //creerArticle();
        //listerArticles();
        
        // try with resources
        // try(Connection connection = DriverManager.getConnection( DB_URL, DB_LOGIN, DB_PWD )) {
        //     System.out.println(connection);
        // } catch ( SQLException e ) {
        //     System.err.println(e.getMessage());
        // }
        
        //Try with final statement
        // Connection connection = null;
        // try {
        //     connection = DriverManager.getConnection( DB_URL, DB_LOGIN, DB_PWD );
        //     System.out.println(connection);
        // } catch ( SQLException throwables ) {
        //     throwables.printStackTrace();
        // } finally {
        //     try {
        //         connection.close();
        //     } catch ( SQLException throwables ) {
        //         throwables.printStackTrace();
        //     }
        // }
    }
    
    private static void authenticate() {
        
        
        Scanner sc = new Scanner( System.in );
        System.out.println("Bienvenue dans mon app...");
        System.out.println("Merci de vous connecter");
        System.out.print("Entrer le login : ");
        String login = sc.nextLine();
        System.out.print("Entrer le password : ");
        String password = sc.nextLine();
    
        IUtilisateurDAO dao = DAOFactory.getUtilisateurDAO();
        try {
            Utilisateur user = dao.findByLoginAndPassword( login, password );
            if (user != null) {
                System.out.println("Bienvenue à toi "+ user.getFullname());
            } else {
                System.out.println("Erreur d'identification");
            }
        } catch ( SQLException e ) {
            System.err.println(e.getMessage());
        }
    
    }
    
    private static void creerArticle() {
        IDAO<Article, Integer> articleDAO = DAOFactory.getArticleDAO();
        Article article = new Article( 4, "toto" );
        try {
            articleDAO.create( article );
        } catch ( SQLException e ) {
            System.err.println(e.getMessage());
        }
    
        //Sample without DAO factory
        // try(Connection connection = DriverManager.getConnection( DB_URL, DB_LOGIN, DB_PWD );
        //     Statement st = connection.createStatement();) {
        //     // connection.setAutoCommit( false );
        //     int nb = st.executeUpdate( "INSERT INTO article (REF) VALUES ('HP-1456')" );
        //
        //     // connection.commit();
        // } catch ( SQLException e ) {
        //     System.err.println(e.getMessage());
        // }
    }
    private static void listerArticles() {
        IDAO<Article, Integer> articleDAO = DAOFactory.getArticleDAO();
        try {
            Set<Article> articleSet = articleDAO.findAll();
            for(Article article : articleSet) {
                System.out.println(article);
            }
        } catch ( SQLException e ) {
            System.err.println(e.getMessage());
        }
    
        //Sample without DAO factory
        // try(Connection connection = DriverManager.getConnection( DB_URL, DB_LOGIN, DB_PWD );
        //     Statement st = connection.createStatement();
        //     ResultSet rs = st.executeQuery( "SELECT * from article" );) {
        //     while ( rs.next() ) {
        //         Article article = new Article(rs.getInt(1),rs.getString( "REF" ));
        //         System.out.println(article);
        //     }
        // } catch ( SQLException e ) {
        //     System.err.println(e.getMessage());
        // }
    }
}
