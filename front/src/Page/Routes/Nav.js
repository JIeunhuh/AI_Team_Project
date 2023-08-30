// Nav 바
import {Link} from 'react-router-dom'

export function Nav() {
  return (
    <nav className="w-full h-[50px] fixed z-50 border border-black flex justify-between items-center">
      <div>
        <Link to="/">
          <p>logo</p>
        </Link>
      </div>
      <div className="flex justify-end items-center">
        <Link to="/static">
          <p className="w-[120px] h-full text-2xl text-center align-middle text-black">통계보기</p>
        </Link>
        <Link to="/login">
          <p className="w-[120px] h-full text-2xl text-center align-middle text-black">로그인</p>
        </Link>
        <Link to="/signup">
          <p className="w-[120px] h-full text-2xl text-center align-middle text-black">회원가입</p>
        </Link>
      </div>
    </nav>
  )
}
