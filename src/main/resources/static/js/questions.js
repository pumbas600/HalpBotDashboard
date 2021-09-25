let addFormIdMessage;
let imageInput;

let typingTimer;                  //timer identifier
const doneTypingInterval = 1000;  //time in ms


$(function() {
    addFormIdMessage = $('#idField').text();
    imageInput = $('#image');

    const previewImage = $('#previewImage');
    previewImage.on('error', function() {
        previewImage.addClass('hide');
    });

    //on keyup, start the countdown
    imageInput.keyup(function(){
        clearTimeout(typingTimer);
        if (imageInput.val()) {
            typingTimer = setTimeout(ShowPreviewImage, doneTypingInterval);
        }
    });

    $('.data-row').each(function(itself, row) {
        row = $(row);
        row.click(function() {
            const selectedRow = $('.selected-row');
            const isSelectedRow = row.hasClass('selected-row');
            // Remove the class from the previously selected row
            selectedRow.removeClass('selected-row');

            if (!isSelectedRow) {
                if ($('.edit-form').hasClass('hide')) {
                    ToggleForms();
                }

                // If they've clicked on the selected row, they're unselecting the row so don't re-select it.
                row.addClass('selected-row');
                UpdateQuestionForm(row);
            }
            else if ($('.add-form').hasClass('hide')) {
                ToggleForms();
            }
        });
    });

});

function ToggleForms() {
    const form = $('#question-form');
    const addForm = $('.add-form');

    addForm.toggleClass('hide');
    $('.edit-form').toggleClass('hide');

    if (addForm.hasClass('hide')) {
        // Edit Question Form
        form.attr('action', '/edit-question');
    }
    else {
        // Add Question Form
        form.attr('action', '/add-question');
        ClearQuestionForm();
    }
}

function UpdateQuestionForm() {
    const id = $('.selected-row td:nth-child(1)').text();

    $('#idField').text(id);
    $('#id').val(id);
    $('#topicId').val($('.selected-row td:nth-child(2)').attr('data-value'));
    $('#question').val($('.selected-row td:nth-child(3)').text());
    $('#answer').val($('.selected-row td:nth-child(4)').text());
    $('#optionB').val($('.selected-row td:nth-child(5)').text());
    $('#optionC').val($('.selected-row td:nth-child(6)').text());
    $('#optionD').val($('.selected-row td:nth-child(7)').text());
    $('#explanation').val($('.selected-row td:nth-child(8)').text());

    const imageValue = $('.selected-row td:nth-child(9)').text();
    imageInput.val(imageValue);
    PreviewImage(imageValue);

}

function ShowPreviewImage() {
    PreviewImage(imageInput.val());
}

function ClearQuestionForm() {
    $('#idField').text(addFormIdMessage);
    $('#id').val('-1');
    $('#topicId').val(1);
    $('#question').val('');
    $('#answer').val('');
    $('#optionB').val('');
    $('#optionC').val('');
    $('#optionD').val('');
    $('#explanation').val('');
    imageInput.val('');
    $('#previewImage').addClass('hide');
}

function PreviewImage(url) {
    const previewImage = $('#previewImage');
    if (url) {
        previewImage.attr('src', url);
        previewImage.removeClass('hide');
    }
    else {
        previewImage.addClass('hide');
    }

}