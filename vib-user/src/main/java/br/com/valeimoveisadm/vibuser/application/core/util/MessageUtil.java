package br.com.valeimoveisadm.vibuser.application.core.util;

import br.com.valeimoveisadm.vibuser.application.core.domain.User;

public abstract class MessageUtil {
    private MessageUtil() {
    }

    public static final String MAP_ENT = "Mapeando Entidade";

    public static final String RETORNO_HTTP = "Retornando resposta da requisicao";

    public static final String INSERINDO_OBJETO_BD = "Inserindo {} na base de dados";
    public static final String BUSCANDO_OBJETO_BD = "Buscando {} na base de dados";
    public static final String ATUALIZANDO_OBJETO_BD = "Atualizando {} na base de dados";
    public static final String REMOVENDO_OBJETO_BD = "Removendo {} na base de dados";

    public static final String INICIANDO_BUSCA_POR_ID = "Iniciando busca por id de um {} na base de dados";

    public static final String LOGANDO_USER_SISTEMA = "Autenticando o usuário no sistema";

    public static final String USER_ENTIDADE_NOME = User.class.getSimpleName();
}
