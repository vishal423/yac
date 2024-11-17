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
package tech.yac.git;

import java.util.LinkedHashMap;
import java.util.Map;

import tech.yac.core.domain.Application;
import tech.yac.core.domain.YacTemplateConfig;
import tech.yac.core.domain.file.YacFile;

public class GitYacTemplateConfig implements YacTemplateConfig {

    private Map<YacFile, YacFile> templates = new LinkedHashMap<>();

    public GitYacTemplateConfig(Application application) {
        configureTemplates(application);
    }

    private void configureTemplates(Application application) {
        addTemplateFile(".gitignore");
        addFiles(".gitscm/info", ".git/info", "exclude");
        addFiles(".gitscm/hooks", ".git/hooks",
            "applypatch-msg.sample",
            "commit-msg.sample",
            "fsmonitor-watchman.sample",
            "post-update.sample",
            "pre-applypatch.sample",
            "pre-commit.sample",
            "pre-merge-commit.sample",
            "pre-push.sample",
            "pre-rebase.sample",
            "pre-receive.sample",
            "prepare-commit-msg.sample",
            "push-to-checkout.sample",
            "update.sample");
        addFiles(".gitscm", ".git", "config",
            "description",
            "HEAD");
        addDirectory(".gitscm", ".git", "refs");
        addDirectory(".gitscm", ".git", "objects");
    }

    @Override
    public String getTemplateRoot() {
        return "git";
    }

    @Override
    public Map<YacFile, YacFile> getTemplates() {
        return templates;
    }
}
