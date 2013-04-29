<import resource="classpath:alfresco/site-webscripts/org/craftercms/common/lib/common-server-api.js">
var mode = page.url.args.mode;
var siteId = CStudioAuthoring.Service.determineShareSite(page.url.templateArgs);
var user = CStudioAuthoring.Service.determineCurrentUser();
var role = CStudioAuthoring.Service.determineAuthoringRoleForUser(siteId, user.id);
var site = CStudioAuthoring.Service.getSite(siteId);

var authoringServer = "";
var formServerUrl = "";
var previewServer = "";
var collabSandbox = "";
var webprojId = "";
var cookieDomain = "";
var liveServer = "";

if (site != undefined) {
	authoringServer = site.authoringUrl;
	formServerUrl = site.formServerUrl;
	previewServer = site.previewUrl;
	liveServer = site.liveUrl;
	collabSandbox = site.collabSandbox;
	webprojId = site.webProject;
	cookieDomain = site.cookieDomain;
} 

model.userId = user.id;
model.authRole = role;
model.siteId = siteId;
model.authoringServer = authoringServer;
model.formServerUrl = formServerUrl;
model.previewServer = previewServer;
model.liveServer = liveServer;
model.mode = (mode) ? mode : "";
model.cookieDomain = cookieDomain;

// prepare selection value
model.selection = (page.url.args.selection) ? page.url.args.selection : 0;

// prepare keywords
var keywords  = page.url.args.keywords;
if(keywords == undefined || keywords == ''){
	model.keywords = '';		
} 
else{
	keywords = decodeURIComponent(keywords); 
	keywords = CStudioAuthoring.Service.encodeHTMLForSearch(keywords)
	model.keywords = keywords;
}

// disable search for first time with empty keyword otherwise enable
var presearch = page.url.args.presearch;
if(presearch != undefined && presearch == 'false' && (keywords == undefined || keywords == '') ){
	model.presearch = 'false'; 
}
else{
	// for direct search from content menu
	var searchId = page.url.args.searchId;
	if(searchId == undefined)
		model.presearch = 'false';
	else
		model.presearch = 'true';
}

//prepare sortBy
var sortBy  = page.url.args.sortBy;
if(sortBy == undefined || sortBy == ''){
	model.sortBy = '';		
} 
else{
	model.sortBy = sortBy;
}
