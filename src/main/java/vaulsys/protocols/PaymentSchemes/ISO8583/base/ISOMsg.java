/*
 * Copyright (c) 2000 jPOS.org.  All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution,
 *    if any, must include the following acknowledgment:
 *    "This product includes software developed by the jPOS project 
 *    (http://www.jpos.org/)". Alternately, this acknowledgment may 
 *    appear in the software itself, if and wherever such third-party 
 *    acknowledgments normally appear.
 *
 * 4. The names "jPOS" and "jPOS.org" must not be used to endorse 
 *    or promote products derived from this software without prior 
 *    written permission. For written permission, please contact 
 *    license@jpos.org.
 *
 * 5. Products derived from this software may not be called "jPOS",
 *    nor may "jPOS" appear in their name, without prior written
 *    permission of the jPOS project.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.  
 * IN NO EVENT SHALL THE JPOS PROJECT OR ITS CONTRIBUTORS BE LIABLE FOR 
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL 
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS 
 * OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) 
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, 
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING 
 * IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
 * POSSIBILITY OF SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the jPOS Project.  For more
 * information please see <http://www.jpos.org/>.
 */

package vaulsys.protocols.PaymentSchemes.ISO8583.base;

import vaulsys.protocols.PaymentSchemes.base.ISOMessageTypes;
import vaulsys.protocols.PaymentSchemes.base.ISOResponseCodes;
import vaulsys.protocols.PaymentSchemes.base.ISOTransactionCodes;
import vaulsys.protocols.base.ProtocolMessage;
import vaulsys.protocols.PaymentSchemes.ISO8583.packager.ISOBasePackager;
import vaulsys.protocols.PaymentSchemes.ISO8583.packager.XMLPackager;
import vaulsys.util.Util;

import java.io.*;
import java.util.BitSet;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Set;

/**
 * implements <b>Composite</b> whithin a <b>Composite pattern</b>
 *
 * @author apr@cs.com.uy
 * @version $Id: ISOMsg.java,v 1.1 2007/02/27 12:46:12 omid Exp $
 * @see ISOComponent
 * @see ISOField
 */
public class ISOMsg extends ISOComponent implements Cloneable, Externalizable, ProtocolMessage {
    protected Hashtable<Integer, ISOComponent> fields;
    protected int maxField;
    protected ISOPackager packager;
    protected boolean dirty, maxFieldDirty;
    protected int direction;
    protected int fieldNumber = -1;
    public static final int INCOMING = 1;
    public static final int OUTGOING = 2;
    private static final long serialVersionUID = 4306251831901413975L;
    //m.rehman: message status
    private int messageStatus;
    public static final int VALID = 1;
    public static final int INVALID = 2;
    protected byte[] header;    //for header data

    /**
     * Creates an ISOMsg
     */
    public ISOMsg() {
        fields = new Hashtable<Integer, ISOComponent>();
        maxField = -1;
        dirty = true;
        maxFieldDirty = true;
        direction = 0;
        messageStatus = VALID;
    }

    /**
     * Creates a nested ISOMsg
     */
    public ISOMsg(int fieldNumber) {
        this();
        setFieldNumber(fieldNumber);
    }

    /**
     * changes this Component field number<br>
     * Use with care, this method does not change any reference held by a Composite.
     *
     * @param fieldNumber new field number
     */
    public void setFieldNumber(int fieldNumber) {
        this.fieldNumber = fieldNumber;
    }

    /**
     * Creates an ISOMsg with given mti
     *
     * @param mti Msg's MTI
     */
    public ISOMsg(String mti) {
        this();
        try {
            setMTI(mti);
        } catch (ISOException e) {
            // should never happen
        }
    }

    /**
     * Sets the direction information related to this message
     *
     * @param direction can be either ISOMsg.INCOMING or ISOMsg.OUTGOING
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }

    /**
     * @return the direction (ISOMsg.INCOMING or ISOMsg.OUTGOING)
     */
    public int getDirection() {
        return direction;
    }

    /**
     * @return true if this message is an incoming message
     */
    public boolean isIncoming() {
        return direction == INCOMING;
    }

    /**
     * @return true if this message is an outgoing message
     */
    public boolean isOutgoing() {
        return direction == OUTGOING;
    }

    /**
     * @return the max field number associated with this message
     */
    public int getMaxField() {
        if (maxFieldDirty)
            recalcMaxField();
        return maxField;
    }

    private void recalcMaxField() {
        maxField = 0;
        for (Enumeration<Integer> e = fields.keys(); e.hasMoreElements();) {
            Integer obj = e.nextElement();
            maxField = Math.max(maxField, obj.intValue());
        }
        maxFieldDirty = false;
    }

    /**
     * @param p -
     *          a peer packager
     */
    public void setPackager(ISOPackager p){ //Raza TPSP Channel Add
        packager = p;
    }

    /**
     * @return the peer packager
     */
    public ISOPackager getPackager() {
        return packager;
    }

    /**
     * Set a field within this message
     *
     * @param c -
     *          a component
     */
    public void set(ISOComponent c) throws ISOException {
        Integer i = (Integer) c.getKey();
        if(c.getValue() == null)
        	return;
        
        fields.put(i, c);
        if (i.intValue() > maxField)
            maxField = i.intValue();
        dirty = true;
    }

    /**
     * Creates an ISOField associated with fldno within this ISOMsg
     *
     * @param fldno field number
     * @param value field value
     */
    public void set(int fldno, String value) throws ISOException {
        if (value != null && !value.equals("")) {
            if (!(packager instanceof ISOBasePackager)) {
                // No packager is available, we can't tell what the field
                // might be, so treat as a String!
                set(new ISOField(fldno, value));
            } else {
                // This ISOMsg has a packager, so use it
                Object obj = ((ISOBasePackager) packager).getFieldPackager(fldno);
                if (obj instanceof ISOBinaryFieldPackager) {
                    set(new ISOBinaryField(fldno, ISOUtil.hex2byte(value)));
                } else {
                    set(new ISOField(fldno, value));
                }
            }
        } else
            unset(fldno);
    }

    /**
     * Creates an ISOBinaryField associated with fldno within this ISOMsg
     *
     * @param fldno field number
     * @param value field value
     */
    public void set(int fldno, byte[] value) throws ISOException {
        if (value != null)
            set(new ISOBinaryField(fldno, value));
        else
            unset(fldno);
    }

    public void set(int fldno, Object value) throws ISOException {
        if (value != null) {
            if (value instanceof byte[]) {
                set(fldno, (byte[]) value);
            } else {
                if (value instanceof String) {
                    set(fldno, (String) value);
                } else if (value instanceof Integer) {
                    set(fldno, ((Integer) value).toString());
                } else 
                	 set(fldno, value.toString());
            }
        }
    }

    /**
     * Unset a field if it exists, otherwise ignore.
     *
     * @param fldno -
     *              the field number
     */
    public void unset(int fldno) {
        if (fields.remove(new Integer(fldno)) != null) {
        	dirty = true;
        	if(maxField <= fldno)
        		maxFieldDirty = true;
     
        }
    }

    /**
     * Unsets several fields at once
     *
     * @param flds -
     *             array of fields to be unset from this ISOMsg
     */
    public void unset(int[] flds) {
        for (int i = 0; i < flds.length; i++)
            unset(flds[i]);
    }

    /**
     * In order to interchange <b>Composites</b> and <b>Leafs</b> we use getComposite(). A <b>Composite component</b> returns itself and a Leaf returns null.
     *
     * @return ISOComponent
     */
    public ISOComponent getComposite() {
        return this;
    }

    /**
     * setup BitMap
     *
     * @throws ISOException
     */
    public void recalcBitMap() throws ISOException {
        if (!dirty)
            return;

        BitSet bmap = new BitSet(((getMaxField() + 62) >> 6) << 6);
        for (int i = 1; i <= maxField; i++)
            if (((ISOComponent) fields.get(new Integer(i))) != null)
                bmap.set(i);
        set(new ISOBitMap(-1, bmap));
        dirty = false;
    }

    /**
     * clone fields
     */
    public Hashtable<Integer, ISOComponent> getChildren() {
        return (Hashtable<Integer, ISOComponent>) fields.clone();
    }

    /**
     * pack the message with the current packager
     *
     * @return the packed message
     * @throws ISOException
     */
    public byte[] pack() throws ISOException {
        synchronized (this) {
            recalcBitMap();
            return packager.pack(this);
        }
    }

    /**
     * unpack a message
     *
     * @param b -
     *          raw message
     * @return consumed bytes
     * @throws ISOException
     */
    public int unpack(byte[] b) throws ISOException {
        synchronized (this) {
            return packager.unpack(this, b);
        }
    }

    public void unpack(InputStream in) throws IOException, ISOException {
        synchronized (this) {
            packager.unpack(this, in);
        }
    }

    // TODO: Uncomment method
    /**
     * dump the message to a PrintStream. The output is sorta XML, intended to be easily parsed. <br>
     * Each component is responsible for its own dump function, ISOMsg just calls dump on every valid field.
     *
     * @param p      -
     *               print stream
     * @param indent -
     *               optional indent string
     */
    public void dump(PrintStream p, String indent) {
        ISOComponent c;
        p.print(indent + "<" + XMLPackager.ISOMSG_TAG);
        switch (direction) {
            case INCOMING:
                p.print(" direction=\"incoming\"");
                break;
            case OUTGOING:
                p.print(" direction=\"outgoing\"");
                break;
        }
        if (fieldNumber != -1)
            p.print(" " + XMLPackager.ID_ATTR + "=\"" + fieldNumber + "\"");
        p.println(">");
        String newIndent = indent + "  ";

        // if (header instanceof Loggeable)
        // ((Loggeable) header).dump (p, newIndent);

        for (int i = 0; i <= maxField; i++) {
            if ((c = (ISOComponent) fields.get(new Integer(i))) != null){
            	if(	
						i == 35 ||
						i == 43 ||
                        i == 48 ||
                 		i == 52 ||
         				i == 54 ||
                		i == 64 ||
                		i == 128){
                		p.println(i+"=-");
                	}
                	else
                		c.dump(p, newIndent);
                    
            }
//                c.dump(p, newIndent);
            //
            // Uncomment to include bitmaps within logs
            //
            // if (i == 0) {
            // if ((c = (ISOComponent) fields.get (new Integer (-1))) != null)
            // c.dump (p, newIndent);
            // }
            //
        }

        p.println(indent + "</" + XMLPackager.ISOMSG_TAG + ">");
    }

    /**
     * get the component associated with the given field number
     *
     * @param fldno the Field Number
     * @return the Component
     */
    public ISOComponent getComponent(int fldno) {
        return fields.get(new Integer(fldno));
    }

    /**
     * Return the object value associated with the given field number
     *
     * @param fldno the Field Number
     * @return the field Object
     */
    public Object getValue(int fldno) throws ISOException {
        ISOComponent c = getComponent(fldno);
        return c != null ? c.getValue() : null;
    }

    /**
     * Return the String value associated with the given ISOField number
     *
     * @param fldno the Field Number
     * @return field's String value
     */
    public String getString(int fldno) {
        String s = "";// null;
        if (hasField(fldno)) {
            try {
                Object obj = getValue(fldno);
                if (obj instanceof String)
                    s = (String) obj;
                else if (obj instanceof byte[])
                    s = ISOUtil.hexString((byte[]) obj);
            } catch (ISOException e) {
                // ignore ISOException - return null
            }
        }
        return s;
    }

    /**
     * Check if a given field is present
     *
     * @param fldno the Field Number
     * @return boolean indicating the existence of the field
     */
    public boolean hasField(int fldno) {
        return fields.get(new Integer(fldno)) != null;
    }

    /**
     * Check if all fields are present
     *
     * @param fields an array of fields to check for presence
     * @return true if all fields are present
     */
    public boolean hasFields(int[] fields) {
        for (int i = 0; i < fields.length; i++)
            if (!hasField(fields[i]))
                return false;
        return true;
    }

    /**
     * Don't call setValue on an ISOMsg. You'll sure get an ISOException. It's intended to be used on Leafs
     *
     * @see ISOField
     * @see ISOException
     */
    public void setValue(Object obj) throws ISOException {
        throw new ISOException("setValue N/A in ISOMsg");
    }

    public Object clone() {
        try {
            ISOMsg m = (ISOMsg) super.clone();
            m.fields = (Hashtable<Integer, ISOComponent>) fields.clone();
            // if (header != null)
            // m.header = (ISOHeader) header.clone();
            return m;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    /**
     * Partially clone an ISOMsg
     *
     * @param fields int array of fields to go
     * @return new ISOMsg instance
     */
    public Object clone(int[] fields) {
        try {
            ISOMsg m = (ISOMsg) super.clone();
            m.fields = new Hashtable<Integer, ISOComponent>();
            for (int i = 0; i < fields.length; i++) {
                if (hasField(fields[i])) {
                    try {
                        m.set(getComponent(fields[i]));
                    } catch (ISOException e) {
                        // it should never happen
                    }
                }
            }
            return m;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    /**
     * add all fields present on received parameter to this ISOMsg<br>
     * please note that received fields take precedence over existing ones (simplifying card agent message creation and template handling)
     *
     * @param m ISOMsg to merge
     */
    public void merge(ISOMsg m) {
        for (int i = 0; i <= m.getMaxField(); i++)
            try {
                if (m.hasField(i))
                    set(m.getComponent(i));
            } catch (ISOException e) {
                // should never happen
            }
    }

    /**
     * @return a string suitable for a log
     */
    public String toString() {
        StringBuffer s = new StringBuffer();
        if (isIncoming())
            s.append("<-- ");
        else if (isOutgoing())
            s.append("--> ");
        else
            s.append("    ");

        s.append(getString(0));
        if (hasField(11)) {
            s.append(' ');
            s.append(getString(11));
        }
        if (hasField(41)) {
            s.append(' ');
            s.append(getString(41));
        }
        return s.toString();
    }

    public Object getKey() throws ISOException {
        if (fieldNumber != -1)
            return new Integer(fieldNumber);
        throw new ISOException("This is not a subField");
    }

    public Object getValue() {
        return this;
    }

    /**
     * @return true on inner messages
     */
    public boolean isInner() {
        return fieldNumber > -1;
    }

    /**
     * @param mti new MTI
     * @throws ISOException if message is inner message
     */
    public void setMTI(String mti) throws ISOException {
        if (isInner())
            throw new ISOException("can't setMTI on inner message");
        System.out.println("MTI setting here [" + mti + "]"); //Raza TEMP
        set(new ISOField(0, mti));
    }

    /**
     * moves a field (renumber)
     *
     * @param oldFieldNumber old field number
     * @param newFieldNumber new field number
     * @throws ISOException
     */
    public void move(int oldFieldNumber, int newFieldNumber) throws ISOException {
        ISOComponent c = getComponent(oldFieldNumber);
        unset(oldFieldNumber);
        if (c != null) {
            c.setFieldNumber(newFieldNumber);
            set(c);
        } else
            unset(newFieldNumber);
    }

    /**
     * @return current MTI
     * @throws ISOException on inner message or MTI not set
     */
    public String getMTI() throws ISOException {
        if (isInner())
            throw new ISOException("can't getMTI on inner message");
        else if (!hasField(0))
            throw new ISOException("MTI not available");
        return (String) getValue(0);
    }

    /**
     * @return true if message "seems to be" a request
     * @throws ISOException on MTI not set
     */
    public Boolean isRequest() throws ISOException {
        //return Character.getNumericValue(getMTI().charAt(2)) % 2 == 0;
        //System.out.println("ISOMsg:: getMTI()) [" + getMTI() + "]"); //Raza TEMP
        //System.out.println("ISOMsg:: getMTI().charAt(2) [" + getMTI().charAt(1) + "]"); //Raza TEMP
        //System.out.println("ISOMsg:: getMTI().charAt(2) [" + getMTI().charAt(2) + "]"); //Raza TEMP
        return Character.getNumericValue(getMTI().charAt(2)) % 2 == 0; //Raza MTI in TPSP case is String with 4 digits
    }

    /**
     * @return true if message "seems not to be" a request
     * @throws ISOException on MTI not set
     */
    public Boolean isResponse() throws ISOException {
        return !isRequest();
    }

    public Boolean isNetworkRequest() throws ISOException {
        //return Character.getNumericValue(getMTI().charAt(2)) % 2 == 0;
        //0620/0630 -- Stand in Authorization parameter update Advice/Response ; 0800/0810 -- Net Management Request/Response ; 0820/0830 -- Net Management Advice/Response ; 0600/0610 --Conversion Rate Inquiry
        return ((getMTI().charAt(1) == '8' || getMTI().charAt(1) == '6')&& (Character.getNumericValue(getMTI().charAt(2)) % 2 == 0));
        //return Character.getNumericValue(getMTI().charAt(3)) % 2 == 0; //Raza MTI in TPSP case is String with 4 digits
    }

    public Boolean isNetworkResponse() throws ISOException {
        return !isNetworkRequest();
    }

    /**
     * @return true if message is Retransmission
     * @throws ISOException on MTI not set
     */
    public boolean isRetransmission() throws ISOException {
        return getMTI().charAt(3) == '1'; //Raza MTI in TPSP case is String with 4 digits
    }

    /**
     * sets an appropiate response MTI.
     * <p/>
     * i.e. 0100 becomes 0110<br>
     * i.e. 0201 becomes 0210<br>
     * i.e. 1201 becomes 1210<br>
     *
     * @throws ISOException on MTI not set or it is not a request
     */
    public void setResponseMTI() throws ISOException {
        if (!isRequest())
            throw new ISOException("not a request - can't set response MTI");

        String mti = getMTI();
        char c1 = mti.charAt(3);
        char c2 = '0';
        switch (c1) {
            case '0':
            case '1':
                c2 = '0';
                break;
            case '2':
            case '3':
                c2 = '2';
                break;
            case '4':
            case '5':
                c2 = '4';
                break;

        }
        set(new ISOField(0, mti.substring(0, 2) + (Character.getNumericValue(getMTI().charAt(2)) + 1) + c2));
    }

    /**
     * sets an appropiate retransmission MTI<br>
     *
     * @throws ISOException on MTI not set or it is not a request
     */
    public void setRetransmissionMTI() throws ISOException {
        if (!isRequest())
            throw new ISOException("not a request");

        set(new ISOField(0, getMTI().substring(0, 3) + "1"));
    }

    protected void writePackager(ObjectOutput out) throws IOException {
        out.writeByte('P');
        String pclass = ((Class) packager.getClass()).getName();
        byte[] b = pclass.getBytes();
        out.writeShort(b.length);
        out.write(b);
    }

    protected void readPackager(ObjectInput in) throws IOException, ClassNotFoundException {
        byte[] b = new byte[in.readShort()];
        in.readFully(b);
        try {
            Class mypClass = Class.forName(new String(b));
            ISOPackager myp = (ISOPackager) mypClass.newInstance();
            setPackager(myp);
        } catch (Exception e) {
            setPackager(null);
        }

    }

    protected void writeDirection(ObjectOutput out) throws IOException {
        out.writeByte('D');
        out.writeByte(direction);
    }

    protected void readDirection(ObjectInput in) throws IOException, ClassNotFoundException {
        direction = in.readByte();
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeByte(0); // reserved for future expansion (version id)
        out.writeShort(fieldNumber);

        // if (header != null)
        // writeHeader (out);
        if (packager != null)
            writePackager(out);
        if (direction > 0)
            writeDirection(out);

        for (Enumeration<ISOComponent> e = fields.elements(); e.hasMoreElements();) {
            ISOComponent c = e.nextElement();
            if (c instanceof ISOMsg) {
                out.writeByte('M');
                ((Externalizable) c).writeExternal(out);
            } else if (c instanceof ISOBinaryField) {
                out.writeByte('B');
                ((Externalizable) c).writeExternal(out);
            } else if (c instanceof ISOField) {
                out.writeByte('F');
                ((Externalizable) c).writeExternal(out);
            }
        }
        out.writeByte('E');
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        in.readByte(); // ignore version for now
        fieldNumber = in.readShort();
        byte fieldType;
        ISOComponent c;
        try {
            while ((fieldType = in.readByte()) != 'E') {
                c = null;
                switch (fieldType) {
                    case 'F':
                        c = new ISOField();
                        break;
                    case 'B':
                        c = new ISOBinaryField();
                        break;
                    case 'M':
                        c = new ISOMsg();
                        break;
                        // case 'H':
                        // readHeader (in);
                        // break;
                    case 'P':
                        readPackager(in);
                        break;
                    case 'D':
                        readDirection(in);
                        break;
                    default:
                        throw new IOException("malformed ISOMsg");
                }
                if (c != null) {
                    ((Externalizable) c).readExternal(in);
                    set(c);
                }
            }
        } catch (ISOException e) {
            throw new IOException(e.getMessage(), e);
        }
    }
      
    public Set<Integer> getFieldNumbers() {
//    	TreeSet<Integer> treeSet = new TreeSet<Integer>();
//    	treeSet.addAll(fields.keySet());  	
//    	return treeSet;

    	return fields.keySet();
    }


    //m.rehman
    public int getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(int messageStatus) {
        this.messageStatus = messageStatus;
    }

    public byte[] getHeader() {
        return header;
    }

    public void setHeader(byte[] header) {
        this.header = header;
    }



    public static ISOMsg MapFieldsForMasterCard(ISOMsg inISOMsg) //For Building ISO message with respect to TPSP (map TranCode etc.)
    {
        System.out.println("Mapping Fields for MasterCard...");
        try {
            if (inISOMsg.isResponse()) {
                inISOMsg.unset(12); //Time-Local-Tran
                inISOMsg.unset(13); //Date-Loc-Tran
                inISOMsg.unset(14); //Date-Expiry
                inISOMsg.unset(25); //POS-Cond-Code
                inISOMsg.unset(42); //Card-Accept-Id-Code
                inISOMsg.unset(64); //Message-Auth-Code
                inISOMsg.unset(100); //Receiving-Inst-Id-Code
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        System.out.println("Mapping Fields for MasterCard Done..!");
        return inISOMsg;
    }

    public static ISOMsg MapFieldsFromMasterCard(ISOMsg inISOMsg) //For Building ISO message with respect to Switch (map TranCode etc.)
    {
        System.out.println("Mapping Fields from MasterCard...");
        /*
        String ProcCode = "", TranCode = "";
        try {
            ProcCode = inISOMsg.getString(3);
            System.out.println("Processing Code Received [" + ProcCode + "]"); //Raza TEMP
            TranCode = ProcCode.substring(0, 2);

            if (TranCode.equals(ISOTransactionCodes.BALANCE_INQUERY_30)) {
                TranCode = ISOTransactionCodes.BALANCE_INQUERY;
                ProcCode = TranCode + ProcCode.substring(2, 6);
                inISOMsg.set(3, ProcCode); //Do not set for now
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        //Set Terminal ID - Field 41

        System.out.println("Processing Code Mapped [" + ProcCode + "]"); //Raza TEMP


        //Validate Auth-ID Field here...!
        try {
            if (!inISOMsg.isRequest()) {

                if(inISOMsg.getString(39).equals(ISOResponseCodes.APPROVED))
                {
                    if(!Util.hasText(inISOMsg.getString(39)))
                    {
                        System.out.println("Authorization Identification Response not present for Approved Transaction. Rejecting Transaction");
                        inISOMsg.setMessageStatus(INVALID);
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        */
        System.out.println("Mapping Fields from MasterCard Done!");
        return inISOMsg;
    }
	
	public static ISOMsg MapFieldsFromTpsp(ISOMsg inISOMsg) //For Building ISO message with respect to Switch (map TranCode etc.)
    {
        System.out.println("Mapping Fields from Tpsp...");
        String ProcCode = "", TranCode = "";
        try {
            ProcCode = inISOMsg.getString(3);
            System.out.println("Processing Code Received [" + ProcCode + "]"); //Raza TEMP
            TranCode = ProcCode.substring(0, 2);

            if (TranCode.equals(ISOTransactionCodes.BALANCE_INQUERY)) {
                TranCode = ISOTransactionCodes.BALANCE_INQUERY;
                ProcCode = TranCode + ProcCode.substring(2, 6);
                inISOMsg.set(3, ProcCode); //Do not set for now
            }
            else if(TranCode.equals(ISOTransactionCodes.BALANCE_INQUERY_31)) //Raza adding for code 31
            {
                TranCode = ISOTransactionCodes.BALANCE_INQUERY_31;
                ProcCode = TranCode + ProcCode.substring(2, 6);
                inISOMsg.set(3, ProcCode); //Do not set for now
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        //Set Terminal ID - Field 41

        System.out.println("Processing Code Mapped [" + ProcCode + "]"); //Raza TEMP


        //Validate Auth-ID Field here...!
        try {
            if (!inISOMsg.isRequest()) {

                if(inISOMsg.getString(39).equals(ISOResponseCodes.APPROVED))
                {
                    if(!Util.hasText(inISOMsg.getString(39)))
                    {
                        System.out.println("Authorization Identification Response not present for Approved Transaction. Rejecting Transaction");
                        inISOMsg.setMessageStatus(INVALID);
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        System.out.println("Mapping Fields from Tpsp Done!");
        return inISOMsg;
    }
	
	public static ISOMsg MapFieldsForTpsp(ISOMsg inISOMsg) //For Building ISO message with respect to TPSP (map TranCode etc.)
    {
        System.out.println("Mapping Fields for Tpsp...");
        /*try {
            if (inISOMsg.isResponse()) {
                inISOMsg.unset(12); //Time-Local-Tran
                inISOMsg.unset(13); //Date-Loc-Tran
                inISOMsg.unset(14); //Date-Expiry
                inISOMsg.unset(25); //POS-Cond-Code
                inISOMsg.unset(42); //Card-Accept-Id-Code
                inISOMsg.unset(64); //Message-Auth-Code
                inISOMsg.unset(100); //Receiving-Inst-Id-Code
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }*/

        System.out.println("Mapping Fields for Tpsp Done..!");
        return inISOMsg;
    }
}
