package njuse.ec.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * rbac_role表.
 * @author 丞
 *
 */
@Entity
@Table(name = "rbac_role")
public class Role implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7624655541899643438L;

	/**
	 * 角色id.
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	private int id;
	
	/**
	 * 身份.
	 */
	@Column(name = "name")
	private String name;
	
	/**
	 * 同角色的用户.
	 */
	@ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
	private Set<User> users;

	/**
	 * @return the id
	 */
	public final int getId() {
		return id;
	}

	/**
	 * @param newId the id to set
	 */
	public final void setId(final int newId) {
		this.id = newId;
	}

	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * @param newName the name to set
	 */
	public final void setName(final String newName) {
		this.name = newName;
	}

	/**
	 * @return the users
	 */
	public final Set<User> getUsers() {
		return users;
	}

	/**
	 * @param newUsers the users to set
	 */
	public final void setUsers(final Set<User> newUsers) {
		this.users = newUsers;
	}
	
}
