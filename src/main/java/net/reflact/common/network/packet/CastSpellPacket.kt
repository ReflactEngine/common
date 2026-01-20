package net.reflact.common.network.packet

import java.io.DataInput
import java.io.DataOutput

class CastSpellPacket : ReflactPacket {
    var spellId: String = ""

    constructor()

    constructor(spellId: String) {
        this.spellId = spellId
    }

    override fun encode(output: DataOutput) {
        output.writeUTF(spellId)
    }

    override fun decode(input: DataInput) {
        spellId = input.readUTF()
    }
}
