var
    img = document.getElementById('img-ods'),
      txtColor = document.querySelectorAll("a:not(.notOds), a:hover"),
    bgColor = document.querySelectorAll(".bg-primary, .btn-primary, .nav-pills .nav-link.active, .btn-primary:hover, .painel-ods"),
    brdrColor = document.querySelectorAll(".btn-primary, .btn-primary:hover, .nav-tabs .nav-link.active"),
    brdrTransp = document.querySelectorAll('.card, textarea.form-control');

var ods = [
    "#e52e3d",
    "#dba639",
    "#4d9e38",
    "#c6272e",
    "#e5352d",
    "#5ebee3",
    "#5ebee3",
    "#a21e42",
    "#e86629",
    "#dd2c67",
    "#ed9c20",
    "#c18b30",
    "#3f7e45",
    "#4b97da",
    "#5bc02b",
    "#33689d",
    "#21486a"
];


for(i=1; i<=17;i++){
    setTimeout(function () {
        img.src = "imagens/ods"+i+".png";
        txtColor.forEach((a) => {
            a.style.color = ods[i];
        });
        bgColor.forEach((b) => {
            b.style.backgroundColor = ods[i];
        });
        brdrColor.forEach((bc) => {
            bc.style.borderColor = ods[i];
        })
        brdrTransp.forEach((bt) => {
            bt.style.borderColor = ods[i];
        })
    }, 4000);
}

