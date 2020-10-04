var tabLinks = document.querySelectorAll(".tablinks");
var tabContent = document.querySelectorAll(".tabcontent");

tabLinks.forEach(function (el) {
  el.addEventListener("click", openTabs);
});


function openTabs(el) {
  var btn = el.currentTarget;
  var electronic = btn.dataset.electronic;

  tabContent.forEach(function (el) {
    el.classList.remove("active");
  });

  tabLinks.forEach(function (el) {
    el.classList.remove("active");
  });

  document.querySelector("#" + electronic).classList.add("active");

  btn.classList.add("active");
}

function myFuntion() {
  var x = document.getElementById("info1");
  var y = document.getElementById("info2");
  var btn = document.getElementById("btnEditInfo");
  var btnC = document.getElementById("btnCancelInfo");

  if (x.style.display === "none") {
    y.style.display = "none";
    x.style.display = "flex";
    btn.innerHTML = "Chỉnh Sửa";
    btn.className = btn.className.replace(' btn-outline-success', ' btn-outline-primary');
    btnCancelInfo.style.display = 'none';
  } else {
    x.style.display = "none";
    y.style.display = "flex";
    btn.innerHTML = "Lưu";
    btn.className = btn.className.replace(' btn-outline-primary', ' btn-outline-success');
    btnCancelInfo.style.display = 'block';
  }
}


let userCurrent = null;
const getLocalStorage = () => {
  if (localStorage.getItem("userCurrent")) {
    userCurrent = JSON.parse(localStorage.getItem('userCurrent'));
  }
};

document.getElementById('btn_logout').addEventListener('click', () => {
  localStorage.setItem("userCurrent", null);
})

getLocalStorage();
console.log(userCurrent);

const renderTabInfo = () => {
  getLocalStorage();
  let htmlcontentInfo1 = `  <div class="tabcontent_infodetail_inf col-4">
   <span>Họ tên</span>
   <h5>
     ${userCurrent.name}

   </h5>
 </div>

 <div class="tabcontent_infodetail_inf col-4">
   <span>Số điện thoại</span>
   <h5>
     ${userCurrent.sdt ? userCurrent.sdt : '...'}

   </h5>
 </div>

 <div class="tabcontent_infodetail_inf col-4">
   <span>Giới tính</span>
   <h5>
     ${userCurrent.gioiTinh}
   </h5>
 </div>

 <div class="tabcontent_infodetail_inf col-4">
   <span>Email</span>
   <h5>
     ${userCurrent.email ? userCurrent.email : '...'}
   </h5>
 </div>

 <div class="tabcontent_infodetail_inf col-4">
   <span>Nơi làm việc</span>
   <h5>
     ${userCurrent.noiLamViec ? userCurrent.noiLamViec : '...'}
   </h5>
 </div>

 <div class="tabcontent_infodetail_inf col-4">
   <span>Sống tại</span>
   <h5>
   ${userCurrent.diaChi ? userCurrent.diaChi : '...'}
   </h5>
 </div>

 <div class="tabcontent_infodetail_inf col-4">
   <span>Mối quan hệ</span>
   <h5>
   ${userCurrent.moiQuanHe ? userCurrent.moiQuanHe : '...'}
   </h5>
 </div>

 <div class="tabcontent_infodetail_inf col-4">
   <span>Liên kết mạng xã hội</span>
   <p class="my-2" style="font-size: 18px; color: #006eff; cursor: pointer;">
     <i class="fa fa-plus-circle" aria-hidden="true"></i> Thêm
     mạng xã hội
   </p>
 </div>

 <div class="tabcontent_infodetail_inf col-4">
   <span>Học vấn</span>
   <h5>
   ${userCurrent.hocVan ? userCurrent.hocVan : '...'}
   </h5>
 </div>

 <div class="tabcontent_infodetail_inf col-4">
   <span>Ngôn ngữ</span>
   <h5>
     Tiếng việt
   </h5>
 </div>

 <div class="tabcontent_infodetail_inf col-4">
   <span>Tôn giáo</span>
   ${userCurrent.tonGiao ? `<h5>
   ${userCurrent.tonGiao}
 </h5>`: ` <p class="my-2" style="font-size: 18px; color: #006eff;cursor: pointer;">
   <i class="fa fa-plus-circle" aria-hidden="true"></i> Thêm
   tôn giáo
 </p>`}
   
 </div>

 <div class="tabcontent_infodetail_inf col-4">
   <span>Sự kiện trog đời</span>
   <p class="my-2" style="font-size: 18px; color: #006eff ;cursor: pointer;">
     <i class="fa fa-plus-circle" aria-hidden="true"></i> Thêm sự
     kiện trong đời
   </p>
 </div>`

  document.getElementById('info1').innerHTML = htmlcontentInfo1;
  let htmlcontentInfo2 = `
   <div class="tabcontent_infodetail_inf col-4">
     <p class="title_sub">Họ tên</p>
     <input class="txt_Sub" type="text" value="${userCurrent.name}" id="txtName">
   </div>

   <div class="tabcontent_infodetail_inf col-4">
     <p class="title_sub">Số điện thoại</p>
     <input class="txt_Sub" type="text" value="${userCurrent.sdt ? userCurrent.sdt : ''}" id="txtSdt">
   </div>

   <div class="tabcontent_infodetail_inf col-4">
     <p class="title_sub">Giới tính</p>
     <input class="txt_Sub" type="text" value="${userCurrent.gioiTinh}" id="txtGender">
   </div>

   <div class="tabcontent_infodetail_inf col-4">
     <p class="title_sub">Email</p>
     <input class="txt_Sub" type="text" value="${userCurrent.email ? userCurrent.email : ''}" id="txtEmail">
   </div>

   <div class="tabcontent_infodetail_inf col-4">
     <p class="title_sub">Nơi làm việc</p>
     <input class="txt_Sub" type="text" value="${userCurrent.noiLamViec ? userCurrent.noiLamViec : ''}" id="txtNoiLamViec">
   </div>

   <div class="tabcontent_infodetail_inf col-4">
     <p class="title_sub">Sống tại</p>
     <input class="txt_Sub" type="text" value="${userCurrent.diaChi ? userCurrent.diaChi : ''}" id="txtDiaChi">
   </div>

   <div class="tabcontent_infodetail_inf col-4">
     <p class="title_sub">Mối quan hệ</p>
     <input class="txt_Sub" type="text" value="${userCurrent.moiQuanHe ? userCurrent.moiQuanHe : '...'}" id="txtMoiQuanHe">
   </div>

   <div class="tabcontent_infodetail_inf col-4">
     <p class="title_sub">Liên kết mạng xã hội</p>
     <p class="my-3" style="margin-top: 10px;font-size: 18px; color: #006eff;cursor: pointer;">
       <i class="fa fa-plus-circle" aria-hidden="true"></i> Thêm
       mạng xã hội
     </p>
   </div>

   <div class="tabcontent_infodetail_inf col-4">
     <p class="title_sub">Học vấn</p>
     <input class="txt_Sub" type="text" value="${userCurrent.hocVan ? userCurrent.hocVan : '...'}" id="txtHocVan">
   </div>

   <div class="tabcontent_infodetail_inf col-4">
     <p class="title_sub">Ngôn ngữ</p>
     <h5 class="txt_Sub">
       Tiếng việt
     </h5>
   </div>

   <div class="tabcontent_infodetail_inf col-4">
     <p class="title_sub">Tôn giáo</p>
     
  
 <input class="txt_Sub" type="text" value="${userCurrent.tonGiao ? userCurrent.tonGiao : ''}" id="txtTonGiao">
   </div>

   <div class="tabcontent_infodetail_inf col-4">
     <p class="title_sub">Sự kiện trog đời</p>
     <p class="my-3" style="margin-top: 10px; font-size: 18px; color: #006eff;cursor: pointer;">
       <i class="fa fa-plus-circle" aria-hidden="true"></i> Thêm sự
       kiện trong đời
     </p>
   </div>
 `;
  document.getElementById('info2').innerHTML = htmlcontentInfo2;
}
renderTabInfo();
const editUser = () => {
  let name = document.getElementById('txtName').value;
  let sdt = document.getElementById('txtSdt').value;
  let gioiTinh = document.getElementById('txtGender').value;
  let noiLamViec = document.getElementById('txtNoiLamViec').value;
  let diaChi = document.getElementById('txtDiaChi').value;
  let moiQuanHe = document.getElementById('txtMoiQuanHe').value;
  let hocVan = document.getElementById('txtHocVan').value;
  let email = document.getElementById('txtEmail').value;
  let tonGiao = document.getElementById('txtTonGiao').value;
  let pass = userCurrent.password;
  let userName = userCurrent.userName;
  let user_Id = userCurrent.user_Id;
  let currentU = { name: name, sdt: sdt, gioiTinh: gioiTinh, noiLamViec: noiLamViec, diaChi: diaChi, moiQuanHe: moiQuanHe, hocVan: hocVan, tonGiao, email: email, password: pass, userName: userName, user_Id: user_Id };
  let newInfo = { name: name, sdt: sdt, gioiTinh: gioiTinh, noiLamViec: noiLamViec, diaChi: diaChi, moiQuanHe: moiQuanHe, hocVan: hocVan, tonGiao, email: email, password: pass };
  console.log(newInfo);
  // localStorage.setItem("userCurrent", JSON.stringify(currentU));
  axios({
    method: 'PUT',
    url: `http://localhost:8080/Social-Original/api/admin/user/${user_Id}`,
    data: newInfo
  }).then((res) => {
    console.log(res);
    localStorage.setItem("userCurrent", JSON.stringify(currentU));
    console.log('thành công');
    getLocalStorage();
    renderTabInfo();
  }).catch((err) => {
    console.log(err);
  })
}
document.getElementById('btnEditInfo').addEventListener('click', () => {
  let btn = document.getElementById('btnEditInfo');
  if (btn.innerHTML === "Lưu") {
    swal({
      title: "Bạn có chắc chứ?",
      text: "Once deleted, you will not be able to recover this imaginary file!",
      icon: "info",
      buttons: true,
    }).then((willDelete) => {
      if (willDelete) {
        swal("Đã cập nhật thông tin thành công", {
          icon: "success",
        });
        editUser();
        myFuntion();
        renderTabInfo();
      } else {
        swal("Your imaginary file is safe!");
      }
    });
  } else {
    myFuntion();
  }
})
document.getElementById('btnCancelInfo').addEventListener('click', () => {
  swal({
    text: "Thông tin của bạn KHÔNG thay đổi !",
    icon: "info",
  })
  myFuntion();
})