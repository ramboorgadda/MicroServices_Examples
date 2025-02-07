package com.rkexample.config;

import com.rkexample.batch.CustomProcessor;
import com.rkexample.batch.CustomReader;
import com.rkexample.batch.CustomWriter;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing
@AllArgsConstructor
public class BatchConfig {
   @Bean
    Job createJob(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager){
    return new JobBuilder("job", jobRepository).flow(createStep(jobRepository,platformTransactionManager)).end().build();
}
@Bean
    Step createStep(JobRepository jobRepository,PlatformTransactionManager platformTransactionManager){
       return new StepBuilder("step",jobRepository)
               .<String,String>chunk(2,platformTransactionManager)
               .allowStartIfComplete(true)
               .reader(new CustomReader())
               .processor(new CustomProcessor())
               .writer(new CustomWriter())
               .build();
}
}
