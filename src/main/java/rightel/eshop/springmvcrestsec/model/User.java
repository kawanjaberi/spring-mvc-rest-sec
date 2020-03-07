package rightel.eshop.springmvcrestsec.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString(exclude="userPassword")
@EqualsAndHashCode
@Entity
@Table(name = "user")
public class User  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @NonNull
    @Column(unique = true)
    private String userName;

    @NonNull
    @Column(unique = true)
    @Email
    private String userEmail;

    @NonNull
    private String userPassword;

    /*
    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return idUser != null ? idUser.equals(user.idUser) : user.idUser == null;
    }

    @Override
    public int hashCode() {
        return idUser != null ? idUser.hashCode() : 0;
    }

     */
}
