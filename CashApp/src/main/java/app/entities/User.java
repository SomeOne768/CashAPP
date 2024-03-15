// package app.entities;

// import java.io.Serializable;
// import java.util.Collection;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.GrantedAuthority;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.Id;
// import jakarta.persistence.Column;
// import jakarta.persistence.Table;
// import jakarta.persistence.GenerationType;

// @Entity
// @Table(name="users") 
// public class User implements Serializable, UserDetails {
 
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
 
//     @Column(nullable = false, unique = true)
//     private String username;
    
//     private String password;

//     public User(String username, String password) {
//       this.username = username;
//       this.password = password;
//     }
      
//     public String getUsername() 
//     {
//         return username;
//     }

//     public String getPassword() 
//     {
//         return password;
//     }

//     public boolean isEnabled() { return true; }

//     public boolean isCredentialsNonExpired() { return true; }

//     public boolean isAccountNonLocked() { return true; }

//     public boolean isAccountNonExpired() { return true; }

//     public Collection< ? extends GrantedAuthority> getAuthorities() { return null; }

// }
