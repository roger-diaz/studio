/*******************************************************************************
 * Crafter Studio Web-content authoring solution
 *     Copyright (C) 2007-2013 Crafter Software Corporation.
 * 
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * 
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 * 
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package org.craftercms.cstudio.impl.service.translation.workflow.handler;

import org.craftercms.cstudio.api.service.workflow.*;
import org.craftercms.cstudio.api.service.translation.*;
import org.craftercms.cstudio.impl.service.workflow.*;
import org.craftercms.cstudio.impl.service.translation.workflow.*;

/**
 * send item out for translation
 * @author rdanner
 */
public class SendItemOutForTranslationHandler implements JobStateHandler {

	/**
	 * given a job, perform an action and return the next state
	 * @param job the job to operate on
	 * @return the next state
	 */
	public String handleState(WorkflowJob job) {
		String path = job.getItems().get(0).getPath();

		String sourceSite = job.getProperties().get("sourceSite");
		String sourceLanguage = job.getProperties().get("sourceLanguage");
		String targetSite = job.getProperties().get("targetSite");
		String basePath = job.getProperties().get("basePath");
		String targetLanguage = job.getProperties().get("targetLanguage");
		
		_translationService.translate(sourceSite, sourceLanguage, targetLanguage, path);
		return "WAITING-FOR-TRANSLATION";
	}

	/** getter translationService */
	public TranslationService getTranslationService() { return _translationService; }
	/** setter for translation service */
	public void setTranslationService(TranslationService service) { _translationService = service; }

	protected TranslationService _translationService;
}
