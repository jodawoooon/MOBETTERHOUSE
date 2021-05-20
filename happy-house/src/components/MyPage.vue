<template>
    <main class="content">
    <div class="main bg-light p-4">
        <div class="row">
            <div class="col-12 col-xl-8">
                <div class="card card-body shadow-sm mb-4">
                    <h2 class="h4 mb-4">회원 정보 수정</h2>
                    <form>
                        <div class="row">
                            <div class="col-md-12 mb-3">
                                <div>
                                    <label for="name">Name</label>
                                    <input class="form-control" id="name" type="text" placeholder="Enter your name" required>
                                </div>
                            </div>
                            
                        </div>
                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <div class="form-group">
                                    <label for="userid">ID</label>
                                    <input class="form-control" id="userid" type="text" placeholder="Enter your id" required>
                                </div>
                            </div>
                            <div class="col-md-6 mb-3">
                                <div class="form-group">
                                    <label for="password">Password</label>
                                    <input class="form-control" id="password" type="password" placeholder="********" required>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <div class="form-group">
                                    <label for="email">Email</label>
                                    <input class="form-control" id="email" type="email" placeholder="ssafy@ssafy.com" required>
                                </div>
                            </div>
                            <div class="col-md-6 mb-3">
                                <div class="form-group">
                                    <label for="phone">Phone</label>
                                    <input class="form-control" id="phone" type="number" placeholder="012-1234-4910" required>
                                </div>
                            </div>
                        </div>
                       
                        <div class="row">
                            <div class="col-sm-12 mb-3">
                                <div class="form-group">
                                    <label for="message">Profile Message</label>
                                    <input class="form-control" id="message" type="text" placeholder="프로필 메세지...." required>
                                </div>
                            </div>
                            
                        </div>
                        
                        <div class="row">
                            <div class="col-md-2 mt-3">
                                <div class="form-group">
                                    <button type="submit" class="btn btn-dark">Save</button>
                                </div>
                            </div>
                            
                        </div>
                    </form>
                </div>
                
            </div>
            <div class="col-12 col-xl-4">
                <div class="row">
                    <div class="col-12 mb-4">
                        <div class="card shadow-sm text-center p-0">
                            <div class="profile-cover rounded-top" data-background="../assets/img/profile-cover.jpg"></div>
                            <div class="card-body pb-5">
                                <img src="../assets/img/team/profile-picture-1.jpg" class="user-avatar large-avatar rounded-circle mx-auto mt-n7 mb-4" alt="Neil Portrait">
                                <h4 class="h3">USER NAME</h4>
                                
                                <p class="text-gray mb-4">프로필메세지 ...........</p>
                                
                            </div>
                         </div>
                    </div>
                    <div class="col-12">
                        <div class="card card-body shadow-sm mb-4">
                            <h2 class="h5 mb-4">Select profile photo</h2>
                            <div class="d-flex align-items-center">
                                <div class="me-3">
                                    <!-- Avatar -->
                                    <div class="user-avatar xl-avatar">
                                        <img class="rounded" src="../assets/img/team/profile-picture-3.jpg" alt="change avatar">
                                    </div>
                                </div>
                                <div class="file-field">
                                    <div class="d-flex justify-content-xl-center ms-xl-3">
                                       <div class="d-flex">
                                          <span class="icon icon-md"><span class="fas fa-paperclip me-3"></span></span> <input type="file">
                                          <div class="d-md-block text-left">
                                             <div class="fw-normal text-dark mb-1">Choose Image</div>
                                             <div class="text-gray small">JPG, GIF or PNG. Max size of 800K</div>
                                          </div>
                                       </div>
                                    </div>
                                 </div>                                        
                            </div>
                        </div>
                    </div>
                    
                </div>
            </div>
        </div>
    </div>
    </main>
</template>

<script>
export default {
    name : 'MyPage',
}
</script>

<style>

</style>