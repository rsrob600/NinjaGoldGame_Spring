/**
 * 
 */

$("div:contains('lost')").each(function () {
  $(this)
    .html($(this)
    .html()
    .replace("log", "<span class='red'>lost</span>"));
});

$("div:contains('earned')").each(function () {
  $(this)
    .html($(this)
    .html()
    .replace("log", "<span class='green'>earned</span>"));
});