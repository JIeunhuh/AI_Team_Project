import papercup from '../../images/yellow-cups-6576738_1280_1.png'
import {Icon} from '../../Component'

export function Section1() {
  return (
    <div className="w-full h-screen relative top-0 flex items-center justify-center">
      <img src={papercup} className="w-full h-full absolute top-0 object-cover" />
      <p className="w-[733px] h-[172px] bg-white opacity-50 absolute rounded-lg text-6xl text-center text-white">
        <span className="w-full text-6xl text-center text-black">Recycling wow....</span>
        <br />
        <button></button>
      </p>
      <Icon name="arrow_downward" className="absolute bottom-6 animate-bounce font-bold text-3xl" />
    </div>
  )
}
