document.addEventListener("DOMContentLoaded", function() {
    const form = document.querySelector("form");

    // 폼 제출 시의 이벤트 처리
    form.addEventListener("submit", function(event) {
        event.preventDefault();  // 기본 폼 제출 방지

        // 입력 필드 값 가져오기
        const email = form.querySelector('input[name="email"]').value;
        const password = form.querySelector('input[name="password"]').value;
        const inviteCode = form.querySelector('input[name="inviteCode"]').value;
        const inviter = form.querySelector('input[name="inviter"]').value;
        const age = form.querySelector('input[name="age"]').value;
        const favorite = form.querySelector('input[name="favorite"]').value;
        const agreeTerms = form.querySelector('input[type="checkbox"]').checked;

        // 폼 유효성 검사
        if (!email || !password || !inviteCode || !inviter || !age || !favorite) {
            alert("모든 필드를 입력해주세요.");
            return;
        }

        if (!agreeTerms) {
            alert("제 3자 정보제공에 동의해야 합니다.");
            return;
        }

        // 모든 조건이 만족되면 폼 제출
        form.submit();
    });
});

    async function login() {
            const email = document.getElementById("email").value;
            const password = document.getElementById("password").value;

            try {
                const response = await fetch('/login', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({ email, password })
                });

                if (response.ok) {
                    window.location.href = '/main_menu'; // 로그인 성공 시 main_menu로 이동
                } else {
                    const errorMessage = await response.text();
                    document.getElementById("error-message").innerText = errorMessage;
                }
            } catch (error) {
                document.getElementById("error-message").innerText = "서버에 문제가 발생했습니다.";
            }
        }

        function goToCreateAccount() {
            window.location.href = "/createAccount";
        }