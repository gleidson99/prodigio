/*******************************************************************************
 * Minerium Meta Framework
 *
 * Licença: GNU Lesser General Public License (LGPL), version 3.
 *  
 * Copyright (C) (2013-2018) Prodemge. Todos os direitos reservados.
 *   
 * Este arquivo é parte do Minerium Meta Framework
 * O Minerium Meta Framework é um software livre; você pode redistribuí-lo e/ou 
 * modificá-lo dentro dos termos da GNU Lesser General Public License (LGPL), version 3.
 *
 * Este framework é distribuído na esperança de que possa ser  útil, 
 * mas SEM NENHUMA GARANTIA; sem uma garantia implícita de ADEQUAÇÃO
 * a qualquer MERCADO ou APLICAÇÃO EM PARTICULAR. 
 * Ver arquivo LICENSE.md no diretório raiz ou acessar <https://www.gnu.org/licenses/lgpl.html>
 *******************************************************************************/
package br.gov.prodigio.controle.componente;

import java.util.Map;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.ext.AfterCompose;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.SimpleConstraint;
import org.zkoss.zul.Window;

import br.gov.prodigio.controle.ProCtr;

public class IntboxBind extends Intbox implements AfterCompose, FieldValidator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7424727966318992050L;
	private String validarQuando = "";
	private String mask;
	private Boolean validarRegra;
	private Boolean validarCampo;
	private String nomeDoObjeto;
	private Object object = null;
	private Boolean upper = true;
	private Boolean validaAoSalvar = false;

	@Override
	public void afterCompose() {
		Window window = ProCtr.findWindow(this);
		ProCtr ctr = (ProCtr) window.getAttribute(window.getId() + "$" + "composer");
		ctr.getProAnnotateDataBinderHelper().adicionaAnotacaoParaCampoIntbox(this);
		configuraConstraint();
		this.setSclass("form-control");
	}

	private void configuraConstraint() {
		GenericConstraint constraint = new GenericConstraint();
		if (this.getConstraint() instanceof SimpleConstraint) {
			constraint.setSimpleConstraint((SimpleConstraint) this.getConstraint());
		}
		this.setConstraint(constraint);
	}

	public void setValidarQuando(String validarQuando) {
		this.validarQuando = validarQuando;
	}

	public String getValidarQuando() {
		return this.validarQuando;
	}

	public String getMask() {
		return mask;
	}

	public void setMask(String mask) {
		this.mask = mask;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.gov.prodigio.controle.componente.FieldValidator#getValidarRegra()
	 */
	@Override
	public Boolean getValidarRegra() {
		return validarRegra;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.gov.prodigio.controle.componente.FieldValidator#setValidarRegra(java.lang.Boolean)
	 */
	@Override
	public void setValidarRegra(Boolean validarRegra) {
		this.validarRegra = validarRegra;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.gov.prodigio.controle.componente.FieldValidator#getValidarCampo()
	 */
	@Override
	public Boolean getValidarCampo() {
		return validarCampo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.gov.prodigio.controle.componente.FieldValidator#setValidarCampo(java.lang.Boolean)
	 */
	@Override
	public void setValidarCampo(Boolean validarCampo) {
		this.validarCampo = validarCampo;
	}

	public String getNomeDoObjeto() {
		return nomeDoObjeto;
	}

	public void setNomeDoObjeto(String nomeDoObjeto) {
		this.nomeDoObjeto = nomeDoObjeto;
	}

	@Override
	public Object getObject() {
		return this.object;
	}

	@Override
	public void setObject(Object o) {
		this.object = o;
	}

	public Object getObjectPai() {
		return objectPai;
	}

	public void setObjectPai(Object objectPai) {
		this.objectPai = objectPai;
	}

	private Object objectPai;
	private Object rootObject;
	private String converter;
	private String identificador;
	private String atributoQueSeraVisualizado;

	@Override
	public Object getRootObject() {
		return this.rootObject;
	}

	@Override
	public void setRootObject(Object rootObject) {
		this.rootObject = rootObject;
	}

	@Override
	public String getConverter() {
		return this.converter;
	}

	@Override
	public void setConverter(String converter) {
		this.converter = converter;
	}

	@Override
	public String getDependeDoComponente() {
		return null;
	}

	@Override
	public void setDependeDoComponente(String dependeDoComponent) {

	}

	@Override
	public void addComponentesDependentes(String nomeDoObjeto, Component field) {

	}

	@Override
	public Map<String, Component> recuperaComponentesDependentes() {
		return null;
	}

	@Override
	public void setIdentificador(String identificador) {
		this.identificador = identificador;

	}

	@Override
	public String getIdentificador() {
		return this.identificador;
	}

	public String getAtributoQueSeraVisualizado() {
		return atributoQueSeraVisualizado;
	}

	public void setAtributoQueSeraVisualizado(String atributoQueSeraVisualizado) {
		this.atributoQueSeraVisualizado = atributoQueSeraVisualizado;
	}

}
