package tech.yac;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import picocli.CommandLine;
import picocli.CommandLine.IFactory;
import tech.yac.cli.YacCli;

/**
 * Your companion to build opinionated Java and SPA applications.
 *
 * @author Vishal Mahajan
 * @since 0.1
 */
@SpringBootApplication
public class Yac implements CommandLineRunner, ExitCodeGenerator {

    private IFactory factory;
    private YacCli cli; 
    private int exitCode;

    Yac(IFactory factory, YacCli cli) {
        this.factory = factory;
        this.cli = cli;
    }

	public static void main(String[] args) {
        System.exit(SpringApplication.exit(SpringApplication.run(Yac.class, args)));
    }

    @Override
    public void run(String... args) throws Exception {
        exitCode = new CommandLine(cli, factory).execute(args);
    }

    @Override
    public int getExitCode() {
        return exitCode;
    }
}
