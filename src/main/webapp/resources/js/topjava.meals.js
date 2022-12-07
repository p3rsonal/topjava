const mealAjaxUrl = "ui/meals/";
const ctx = {
    ajaxUrl: mealAjaxUrl,
    mealAjaxUrl: mealAjaxUrl
};
let filterForm;

$(function () {
    $("#datetimepicker").datetimepicker({
        format: 'd.m.Y H:i',
        closeOnDateSelect: true
    });
    
    filterForm = $("#filter-form");

    makeEditable($("#datatable").DataTable({
        "paging": false,
        "info": true,
        "columns": [
            {
                "data": "dateTime"
            },
            {
                "data": "description"
            },
            {
                "data": "calories"
            },
            {
                "defaultContent": "Update",
                "orderable": false
            },
            {
                "defaultContent": "Delete",
                "orderable": false
            }
        ],
        "order": [
            [
                0,
                "asc"
            ]
        ]
    }));
});

function filter() {
    $.get(mealAjaxUrl + "filter?" + filterForm.serialize(),
        function (meals) {
            ctx.datatableApi.clear().rows.add(meals).draw();
        });
}

function resetFilter() {
    filterForm[0].reset();
    updateTable();
}