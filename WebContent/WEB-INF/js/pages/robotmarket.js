$(function() {

	$("ul.nav").superfish({
		animation : {
			height : "show",
			width : "show"
		},
		speed : 500
	});

	// tooltip
	$(".tooltip").easyTooltip();
	
	$('a.display_open').click(
			function() {

				var divparent = $(this).parents("div.display_open");
				$(divparent[divparent.length - 1]).find("img.display_open").toggle();
				$(divparent[divparent.length - 1]).find("img.display_close").toggle();
				$(divparent[divparent.length - 1]).find("ul.display_close").toggle();
			});


	// Check all the checkboxes when the head one is selected:
	$('.checkall').click(
			function() {

				var formparents = $(this).parents("form");
				$(formparents[formparents.length - 1]).parent().find(
						"input[type='checkbox']").attr('checked',
						$(this).is(':checked'));
			});

	$(".close").click(function() {
		$(this).fadeTo(400, 0, function() { // Links with the class "close" will
											// close parent
			$(this).slideUp(400);
		});
		return false;
	});

	// sortable, portlets
	$(".column").sortable({
		connectWith : '.column'
	});

/*	$(".sort").sortable({
		connectWith : '.sort'
	});
*/
	$(".portlet").addClass(
			"ui-widget ui-widget-content ui-helper-clearfix ui-corner-all")
			.find(".portlet-header").addClass("ui-widget-header ui-corner-all")
			.prepend('<span class="ui-icon ui-icon-circle-arrow-s"></span>')
			.end().find(".portlet-content").toggle();

	$(".portlet-header .ui-icon").click(function() {
		$(this).toggleClass("ui-icon-minusthick");
		$(this).parents(".portlet:first").find(".portlet-content").toggle();
	});

	$(".column").disableSelection();

	$(".portlet-heard .ui-icon").toggleClass("ui-icon-minusthick");
	$("#sidebartabs-1 .portlet").find(".portlet-content").toggle();


	// Tabs
	$('#tabs').tabs();
	$('#sidebartabs').tabs();
	
	
	// Dialog
	$('#dialogRobotSetting').dialog({
		modal : true,
		autoOpen : false,
		width : 500,
		draggable : true,
		resizable : false,
		buttons : {
			"确认" : function() {
				$(this).dialog("close");
			},
			"取消" : function() {
				$(this).dialog("close");
			}
		}
	});

	// Dialog Link
	$('.dialogRobotSetting_link').click(function() {
		$('#dialogRobotSetting').dialog('open');
		return false;
	});

	// hover states on the static widgets
	$('.dialogRobotSetting_link, ul#icons li').hover(function() {
		$(this).addClass('ui-state-hover');
	}, function() {
		$(this).removeClass('ui-state-hover');
	});
	
	showHello();
	setInterval("showHello()", 10000);

});

