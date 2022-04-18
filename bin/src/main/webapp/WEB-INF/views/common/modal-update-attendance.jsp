<div class="modal fade" id="update-modal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Update Attendance</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-6">
                        <label for="create-time">Create Time:</label>
                        <input type="time" class="form-control" id="create-time">
                    </div>
                    <div class="col-md-6">
                        <label for="end-time">End Time:</label>
                        <input type="time" class="form-control" id="end-time">
                    </div>
                </div>
                <p id="error"></p>
            </div>
            <div class="modal-footer d-flex justify-content-end">
                <button type="button" class="btn btn-info btn-sm" id="btn-update-attendance">Update</button>
            </div>
        </div>
    </div>
</div>