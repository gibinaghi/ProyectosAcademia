export default function setTime(time) {
  setTimeout(() => {
    window.location.reload()
  }, time)
}