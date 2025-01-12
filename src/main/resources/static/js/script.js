document.addEventListener('DOMContentLoaded', () => {
    const passwordInput = document.getElementById('password');
    const togglePasswordButton = document.getElementById('togglePassword');
    const eyeIcon = document.getElementById('eyeIcon');
    const eyeSlashIcon = document.getElementById('eyeSlashIcon');

    eyeIcon.classList.add('hidden');
    eyeSlashIcon.classList.remove('hidden');

    togglePasswordButton.addEventListener('click', () => {
        const isPasswordHidden = passwordInput.type === 'password';
        passwordInput.type = isPasswordHidden ? 'text' : 'password';

        if (isPasswordHidden) {
            eyeIcon.classList.remove('hidden');
            eyeSlashIcon.classList.add('hidden');
        } else {
            eyeIcon.classList.add('hidden');
            eyeSlashIcon.classList.remove('hidden');
        }
    });
});