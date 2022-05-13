package br.com.spring.mvc.mudi.dto;

import javax.validation.constraints.NotBlank;

import br.com.spring.mvc.mudi.model.Pedido;
import br.com.spring.mvc.mudi.model.StatusPedido;

public class RequisicaoNovoPedido {
	
	@NotBlank // gerar uma mensagem defaul atraves de "NotBlank.requisicaoNovoPedido.nomeProduto"
	private String nomeProduto; 
	@NotBlank 
	private String urlProduto; 
	@NotBlank
	private String imagemProduto;
	@NotBlank
	private String descricao;
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getUrlProduto() {
		return urlProduto;
	}
	public void setUrlProduto(String urlProduto) {
		this.urlProduto = urlProduto;
	}
	public String getImagemProduto() {
		return imagemProduto;
	}
	public void setImagemProduto(String imagemProduto) {
		this.imagemProduto = imagemProduto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Pedido toPedido() {
		Pedido pedido = new Pedido();
		
		pedido.setDescricao(descricao);
		pedido.setNomeProduto(nomeProduto);
		pedido.setUrlImagem(imagemProduto);
		pedido.setUrlProduto(urlProduto);
		pedido.setStatus(StatusPedido.AGUARDANDO);
		return pedido;
	}
	
	
}
