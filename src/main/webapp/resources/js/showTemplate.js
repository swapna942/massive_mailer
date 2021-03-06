var templateList = [];

$(document).ready(function() {

	$("#templateList").change(function(evt) {
        ApplyTemplateToUI(evt.target.value);
	});

    retrieveTemplateListFromServer(function(data) {
        templateList = data;
   		renderTemplateList(templateList, $('#templateList'));
    });
});

function retrieveTemplateListFromServer(callback)
{
	$.ajax({
	    type: 'GET',
	    url: 'templates',
	    dataType: 'json',
	    success: function(data) { callback(data) }
	});
}

function renderTemplateList(json, selector)
{
	selector.append($('<option>').text('No Template').attr('value', 0).attr('id', 'template_0'));
	
	$.each(json, function(idx, item) {
		selector.append($('<option>').text(item.attributes.TemplateName).attr('value', item.id).attr('id', 'template_'+ item.id));
	})
}

function ApplyTemplateToUI(templateID)
{
    for (var i = 0; i < templateList.length; i++) {
        if (templateList[i].id == templateID) {
            var selectedTemplate = templateList[i];

            $("#content").val(templateList[i].attributes.Content);
            $("#subject").val(templateList[i].attributes.Subject);

            return;
        }
    }

    $("#content").val('');
    $("#subject").val('');
}
