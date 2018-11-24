package com.cubdream;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Aluno
{

@SerializedName("nome")
@Expose
private String nome;

public String getNome()
	{
		return nome;
	}

public void setNome(String nome) 
	{
		this.nome = nome;
	}
}

