/*
 * Copyright (C) 2007-2013 Crafter Software Corporation.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.craftercms.cstudio.alfresco.dm.service.api;

import org.apache.commons.lang.StringUtils;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: dejan
 * Date: 12/22/11
 * Time: 3:23 PM
 * To change this template use File | Settings | File Templates.
 */
public interface DmContentLifeCycleService {

    /**
     * content operations
     *
     * @author hyanghee
     *
     */
    public enum ContentLifeCycleOperation {

        // cut is rename and duplicate is copy
        COPY, DELETE, DUPLICATE, NEW, RENAME, REVERT, UPDATE;

        /**
         * get the enum type of the opration given
         *
         * @param operation
         * @return
         */
        public static ContentLifeCycleOperation getOperation(String operation) {
            if (!StringUtils.isEmpty(operation)) {
                return Enum.valueOf(ContentLifeCycleOperation.class, operation);
            } else {
                return null;
            }
        }

    }

    /**
     * process contnet lifecycle
     *
     * @param site
     * @param user
     * @param path
     * @param contentType
     * @param operation
     * @param params
     */
    public void process(String site, String user, String path, String contentType, ContentLifeCycleOperation operation,
                        Map<String, String> params);
}
