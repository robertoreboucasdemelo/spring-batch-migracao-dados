package com.moduretick.writer;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import javax.sql.DataSource;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.moduretick.domain.DadosBancarios;
import com.moduretick.domain.Pessoa;

@Configuration
public class BancoDadosbancariosWriterConfig {
	@Bean
	public JdbcBatchItemWriter<DadosBancarios> bancoDadosBancariosWriter(
			@Qualifier("appDataSource") DataSource dataSource){
		
		return new JdbcBatchItemWriterBuilder<DadosBancarios>()
				.dataSource(dataSource)
				.sql("INSERT INTO dados_bancarios (id, pessoa_id, agencia, conta, banco) VALUES (:id, :pessoaID, :agencia, :conta, :banco)")
				.beanMapped()
				.build();
		
	}

}
