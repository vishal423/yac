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
package tech.yac.core.service;

import java.nio.file.Path;
import java.nio.file.Paths;

import tech.yac.core.domain.file.YacFileContent;
import tech.yac.core.exception.YacException;

public class LogYacFileService implements YacFileService {

    @Override
    public void write(String fileRoot, YacFileContent file) throws YacException {
        System.out.println("Writing " + getFilePath(fileRoot, file).toString());
    }

    private Path getFilePath(String fileRoot, YacFileContent file) {
        if(file.getFile().getPath().isPresent()) {
            return Paths.get(fileRoot, file.getFile().getPath().get(), file.getFile().getName());
        }
        return Paths.get(fileRoot, file.getFile().getName());
    }
}

