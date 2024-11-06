/*
 * YAC -- Companion to build opinionated Java and SPA applications.
 * Copyright (C) 2024 Vishal Mahajan
 *
 * This package is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; version 2 of the
 * license as found in the file LICENSE.
 *
 * This package is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
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
