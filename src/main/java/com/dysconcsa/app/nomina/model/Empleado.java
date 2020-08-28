/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dysconcsa.app.nomina.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author jmigu
 */
@Entity
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
		@NamedQuery(name = "Empleado.findById", query = "SELECT e FROM Empleado e WHERE e.id = :id"),
		@NamedQuery(name = "Empleado.findByNombres", query = "SELECT e FROM Empleado e WHERE e.nombres = :nombres"),
		@NamedQuery(name = "Empleado.findByApellidos", query = "SELECT e FROM Empleado e WHERE e.apellidos = :apellidos"),
		@NamedQuery(name = "Empleado.findByIdentificacion", query = "SELECT e FROM Empleado e WHERE e.identificacion = :identificacion"),
		@NamedQuery(name = "Empleado.findByInss", query = "SELECT e FROM Empleado e WHERE e.inss = :inss"),
		@NamedQuery(name = "Empleado.findByNumEmpleado", query = "SELECT e FROM Empleado e WHERE e.numEmpleado = :numEmpleado"),
		@NamedQuery(name = "Empleado.findByFechaIng", query = "SELECT e FROM Empleado e WHERE e.fechaIng = :fechaIng"),
		@NamedQuery(name = "Empleado.findByFechaNac", query = "SELECT e FROM Empleado e WHERE e.fechaNac = :fechaNac"),
		@NamedQuery(name = "Empleado.findBySalarioBase", query = "SELECT e FROM Empleado e WHERE e.salarioBase = :salarioBase"),
		@NamedQuery(name = "Empleado.findByActivo", query = "SELECT e FROM Empleado e WHERE e.activo = :activo"),
		@NamedQuery(name = "Empleado.findByFoto", query = "SELECT e FROM Empleado e WHERE e.foto = :foto") })
public class Empleado implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	@Basic(optional = false)
	@Column(name = "nombres")
	private String nombres;
	@Basic(optional = false)
	@Column(name = "apellidos")
	private String apellidos;
	@Column(name = "identificacion")
	private String identificacion;
	@Column(name = "inss")
	private Integer inss;
	@Column(name = "num_empleado")
	private Integer numEmpleado;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fecha_ing")
	private LocalDate fechaIng;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fecha_nac")
	private LocalDate fechaNac;
	@Column(name = "salario_base")
	private Long salarioBase;
	@Column(name = "activo")
	private Boolean activo;
	@Lob
	@Column(name = "nota")
	private String nota;
	@Column(name = "foto")
	private String foto;
	@Lob
	@Column(name = "direccion")
	private String direccion;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
	private List<Horario> horarioList;
	@JoinColumn(name = "cargo", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Cargos cargo;
	@JoinColumn(name = "departamento", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Departamento departamento;
	@OneToMany(mappedBy = "idempleado", fetch = FetchType.LAZY)
	private List<Salario> salarioList;
	@OneToMany(mappedBy = "idempleado", fetch = FetchType.LAZY)
	private List<Documentacion> documentacionList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.LAZY)
	private List<Salida> salidaList;

	public Empleado() {
	}

	public Empleado(Integer id) {
		this.id = id;
	}

	public Empleado(Integer id, String nombres, String apellidos) {
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public Integer getInss() {
		return inss;
	}

	public void setInss(Integer inss) {
		this.inss = inss;
	}

	public Integer getNumEmpleado() {
		return numEmpleado;
	}

	public void setNumEmpleado(Integer numEmpleado) {
		this.numEmpleado = numEmpleado;
	}

	public LocalDate getFechaIng() {
		return fechaIng;
	}

	public void setFechaIng(LocalDate fechaIng) {
		this.fechaIng = fechaIng;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public Long getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Long salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	@XmlTransient
	public List<Horario> getHorarioList() {
		return horarioList;
	}

	public void setHorarioList(List<Horario> horarioList) {
		this.horarioList = horarioList;
	}

	public Cargos getCargo() {
		return cargo;
	}

	public void setCargo(Cargos cargo) {
		this.cargo = cargo;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@XmlTransient
	public List<Salario> getSalarioList() {
		return salarioList;
	}

	public void setSalarioList(List<Salario> salarioList) {
		this.salarioList = salarioList;
	}

	@XmlTransient
	public List<Documentacion> getDocumentacionList() {
		return documentacionList;
	}

	public void setDocumentacionList(List<Documentacion> documentacionList) {
		this.documentacionList = documentacionList;
	}

	@XmlTransient
	public List<Salida> getSalidaList() {
		return salidaList;
	}

	public void setSalidaList(List<Salida> salidaList) {
		this.salidaList = salidaList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Empleado)) {
			return false;
		}
		Empleado other = (Empleado) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Empleado[id=" + id + ", nombre: " + nombres + " " + apellidos + ", direccion: " + direccion
				+ ", Departamento: " + departamento + ", cargo: " + cargo + "]";
	}

}
