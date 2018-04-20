package co.edu.usbcali.banco.modelo;
// Generated 13/04/2018 09:07:58 PM by Hibernate Tools 5.2.8.Final

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Cuenta generated by hbm2java
 */
@Entity
@Table(name = "cuenta", schema = "public")
public class Cuenta implements java.io.Serializable {

	private String cuenId;
	private Cliente cliente;
	private BigDecimal saldo;
	private String clave;
	private char activa;
	private Set<CuentaRegistrada> cuentaRegistradas = new HashSet<CuentaRegistrada>(0);
	private Set<Transaccion> transaccions = new HashSet<Transaccion>(0);

	public Cuenta() {
	}

	public Cuenta(String cuenId, BigDecimal saldo, String clave, char activa) {
		this.cuenId = cuenId;
		this.saldo = saldo;
		this.clave = clave;
		this.activa = activa;
	}

	public Cuenta(String cuenId, Cliente cliente, BigDecimal saldo, String clave, char activa,
			Set<CuentaRegistrada> cuentaRegistradas, Set<Transaccion> transaccions) {
		this.cuenId = cuenId;
		this.cliente = cliente;
		this.saldo = saldo;
		this.clave = clave;
		this.activa = activa;
		this.cuentaRegistradas = cuentaRegistradas;
		this.transaccions = transaccions;
	}

	@Id

	@Column(name = "cuen_id", unique = true, nullable = false)
	public String getCuenId() {
		return this.cuenId;
	}

	public void setCuenId(String cuenId) {
		this.cuenId = cuenId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clie_id")
	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Column(name = "saldo", nullable = false, precision = 30, scale = 6)
	public BigDecimal getSaldo() {
		return this.saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	@Column(name = "clave", nullable = false)
	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Column(name = "activa", nullable = false, length = 1)
	public char getActiva() {
		return this.activa;
	}

	public void setActiva(char activa) {
		this.activa = activa;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cuenta")
	public Set<CuentaRegistrada> getCuentaRegistradas() {
		return this.cuentaRegistradas;
	}

	public void setCuentaRegistradas(Set<CuentaRegistrada> cuentaRegistradas) {
		this.cuentaRegistradas = cuentaRegistradas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cuenta")
	public Set<Transaccion> getTransaccions() {
		return this.transaccions;
	}

	public void setTransaccions(Set<Transaccion> transaccions) {
		this.transaccions = transaccions;
	}

}