package koios.ivana.josipovgablec.model;

import javax.persistence.*;

@Entity
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long login_id;

    @Column(unique = true)
    private String username;
    private String password;


    public Login(Long login_id, String username, String password) {
        this.login_id = login_id;
        this.username = username;
        this.password = password;
    }

    public Login() {
    }

    public Long getLogin_id() {return login_id;}
    public void setLogin_id(Long login_id) {this.login_id = login_id;}
    public String getUsername() {return username; }
    public void setUsername(String username) { this.username = username;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

}
